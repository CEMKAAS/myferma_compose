package com.zaroslikov.myfermacompose.ui


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.zaroslikov.myfermacompose.R
import com.zaroslikov.myfermacompose.data.ferma.ProjectTable
import com.zaroslikov.myfermacompose.ui.navigation.Screens

@Composable
fun StartScreen(
    navController: NavController,
    viewModel: StartScreenViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val countAD by viewModel.getFullSchedule().collectAsState(emptyList())
    Scaffold(
        topBar = {
            TopAppBarStart(title = "Мое Хозяйство", canNavigateBack = false)
        }, floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { navController.navigate("ChooiseProject") },
                icon = { Icon(Icons.Filled.Add, "Localized description") },
                text = { Text(text = "Добавить") },
            )
        }
    ) { innerPadding ->
        StartScreenContainer(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            projectList = countAD
        )
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StartScreenContainer(
    modifier: Modifier,
    navController: NavController,
    projectList: List<ProjectTable>
) {
    var state by remember { mutableStateOf(0) }
    val titles = listOf("Действующие", "Архив")
    val pagerState = rememberPagerState {
        titles.size
    }

    Column(modifier = modifier) {
        LaunchedEffect(key1 = state) {
            pagerState.animateScrollToPage(state)
        }
        LaunchedEffect(key1 = pagerState.currentPage) {
            state = pagerState.currentPage
        }
        Column {
            TabRow(selectedTabIndex = state) {
                titles.forEachIndexed { index, title ->
                    Tab(
                        selected = state == index,
                        onClick = { state = index },
                        text = {
                            Text(
                                text = title,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    )
                }
            }
            HorizontalPager(
                state = pagerState,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(16.dp)
                ) {
//                    items(30) {
                    items(projectList) {
                        CardFerma(
                            navController = navController,
                            it.id,
                            it.picture,
                            it.titleProject,
                            it.dateBegin
                        )
//                        CardIncubator(navController = navController)
                    }
                }
            }
        }
    }
}


@Composable
fun CardFerma(navController: NavController, id: Int, picture: ByteArray, title: String, date: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                navController.navigate(Screens.ScreenWareHouseRoute.route+"/$id")

            },
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors()
    ) {


//        Image(
//            bitmap = byteArrayToBitmap(picture).asImageBitmap(),
//            contentDescription = null,
//            contentScale = ContentScale.Fit,
//            modifier = Modifier.size(194.dp)
//        )
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 5.dp)
        )
        Text(
            text = date, fontSize = 15.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
                .padding(bottom = 10.dp)
        )
    }
}

fun byteArrayToBitmap(data: ByteArray): Bitmap {
    return BitmapFactory.decodeByteArray(data, 0, data.size)
}

//@Preview(showBackground = true)
//@Composable
//fun StartScreenContainerPrewie(
//    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
//    scope: CoroutineScope = rememberCoroutineScope(),
//    navController: NavHostController = rememberNavController(),
//) {
//    StartScreenContainer(
//        modifier = Modifier.fillMaxSize(),
//        navController = navController,
//    )
//}


//@Preview(showBackground = true)
//@Composable
//fun StartScreenPrewie(
//    navController: NavHostController = rememberNavController(),
//    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
//    scope: CoroutineScope = rememberCoroutineScope(),
//
//
//    ) {
//    StartScreen(navController)
//}

@Composable
fun CardIncubator(
    navController: NavController
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                navController.navigate(Screens.FermaRoute.route)
            },
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors()
    ) {

        Image(
            painter = painterResource(id = R.drawable.chicken),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(194.dp)
        )
        Text(
            text = "Инкубатор №1",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 5.dp)
        )
        Text(
            text = "Идет 33 день", fontSize = 15.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
                .padding(bottom = 10.dp)
        )
    }
}