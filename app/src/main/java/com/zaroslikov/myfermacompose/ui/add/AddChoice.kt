package com.zaroslikov.myfermacompose.ui.add

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zaroslikov.myfermacompose.R
import com.zaroslikov.myfermacompose.ui.DrawerItems
import com.zaroslikov.myfermacompose.ui.TopAppBarStart


@Composable
fun ChooiseProject(navController: NavController, navigateBack: () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBarStart(title = "Мое Хозяйство", true, navigateUp = navigateBack)
        }) { innerPadding ->
        ChooiseProjectContainer(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxHeight(),
            navController
        )
    }
}


@Composable
fun ChooiseProjectContainer(modifier: Modifier, navController: NavController) {

    val drawerItems = listOf(
        DrawerItems(
            R.drawable.chicken, "Инкубатор", "AddIncubator"
        ),
        DrawerItems(
            R.drawable.baseline_warehouse_24, "Хозяйство", "AddProject"
        ),
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = " Выберите интересующий Вас проект",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp), verticalArrangement = Arrangement.Center,
        ) {
            items(drawerItems.size) {
                AddIncubatorCard(
                    drawerItems[it].text,
                    drawerItems[it].icon,
                    drawerItems[it].route,
                    navController
                )
            }
        }
    }
}

@Composable
fun AddIncubatorCard(title: String, image: Int, route: String, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                navController.navigate(route)
            },
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(),
    ) {
        Box(
            modifier = Modifier.height(200.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(vertical = 5.dp, horizontal = 5.dp)
            )
        }

    }
}


//@Preview(showBackground = true)
//@Composable
//fun AddIncubatorCardPrewie() {
//    AddIncubatorCard()
//}

@Preview(showBackground = true)
@Composable
fun ChooiseProjectPrewie() {
    ChooiseProjectContainer(
        modifier = Modifier.fillMaxSize(),
        navController = rememberNavController()
    )
}

@Preview(showBackground = true)
@Composable
fun ChooiPrewie() {
    ChooiseProject(navController = rememberNavController(), navigateBack = {})
}