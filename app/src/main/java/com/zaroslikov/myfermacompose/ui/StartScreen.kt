package com.zaroslikov.myfermacompose.ui


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.zaroslikov.myfermacompose.R
import com.zaroslikov.myfermacompose.ui.navigator.ContainerApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun StartScreen(scope: CoroutineScope, drawerState: DrawerState, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = "Мое Хозяйство", scope = scope, drawerState = drawerState)
        }, floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { /* do something */ },
                icon = { Icon(Icons.Filled.Add, "Localized description") },
                text = { Text(text = "Добавить") },
            )
        }
    ) { innerPadding ->
        StartScreenContainer(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            scope = scope
        )
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StartScreenContainer(modifier: Modifier, navController: NavController, scope: CoroutineScope) {
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
                    items(6) {
                        CardFerma(navController = navController, scope = scope)
                    }
                }
            }
        }
    }

}

@Composable
fun CardIncubator() {
    Card(
        modifier = Modifier
            .padding(8.dp),
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

@Composable
fun CardFerma(navController: NavController, scope: CoroutineScope) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                navController.navigate("MyFerma")
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
            text = "Птицеводство",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 5.dp)
        )
        Text(
            text = "-350 рублей", fontSize = 15.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
                .padding(bottom = 10.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun StartScreenContainerPrewie(
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    scope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
) {
    StartScreenContainer(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        scope = scope
    )
}


@Preview(showBackground = true)
@Composable
fun StartScreenPrewie(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    scope: CoroutineScope = rememberCoroutineScope()

) {
    StartScreen(scope, drawerState, navController)
}