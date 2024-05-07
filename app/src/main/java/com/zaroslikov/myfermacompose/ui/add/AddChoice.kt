package com.zaroslikov.myfermacompose.ui.add

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zaroslikov.myfermacompose.R
import com.zaroslikov.myfermacompose.ui.CardFerma
import com.zaroslikov.myfermacompose.ui.DrawerItems
import com.zaroslikov.myfermacompose.ui.TopAppBar
import kotlinx.coroutines.CoroutineScope


@Composable
fun ChooiseProject(scope: CoroutineScope, drawerState: DrawerState, navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(title = "Мое Хозяйство", scope = scope, drawerState = drawerState)
        }) { innerPadding ->
        ChooiseProjectContainer(modifier = Modifier.padding(innerPadding), navController)
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
        Text(text = "Выберите проект!")

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp), verticalArrangement = Arrangement.Center
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
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                )
            Text(
                text = title,
                fontSize = 16.sp,
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
    ChooiseProjectContainer(modifier = Modifier.fillMaxSize(), navController = rememberNavController())
}

//@Preview(showBackground = true)
//@Composable
//fun AddProductSheetPrewie() {
//    AddProductSheet(showBottom = remember { mutableStateOf(false) })
//}