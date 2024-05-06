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
import com.zaroslikov.myfermacompose.R
import com.zaroslikov.myfermacompose.ui.CardFerma
import com.zaroslikov.myfermacompose.ui.DrawerItems
import com.zaroslikov.myfermacompose.ui.TopAppBar
import kotlinx.coroutines.CoroutineScope


@Composable
fun ChooiseProject(scope: CoroutineScope, drawerState: DrawerState) {

    Scaffold(
        topBar = {
            TopAppBar(title = "Мое Хозяйство", scope = scope, drawerState = drawerState)
        }) { innerPadding ->
        ChooiseProjectContainer(modifier = Modifier.padding(innerPadding))
    }
}


@Composable
fun ChooiseProjectContainer(modifier: Modifier) {

    val drawerItems = listOf(

        DrawerItems(
            R.drawable.baseline_arrow_back_24, "Вернуться к проектам", "Start"
        ),
        DrawerItems(
            R.drawable.baseline_warehouse_24, "Мой Склад", "MyFerma"
        ),
        DrawerItems(
            R.drawable.baseline_currency_ruble_24, "Мой Финансы", "Finance"
        ),
        DrawerItems(
            R.drawable.baseline_add_circle_outline_24, "Мои Товары", "Add"
        ),
        DrawerItems(
            R.drawable.baseline_add_card_24, "Мои Продажи", "Sale"
        ),
        DrawerItems(
            R.drawable.baseline_add_shopping_cart_24, "Мои Покупки", "Expenses"
        ),
        DrawerItems(
            R.drawable.baseline_edit_note_24, "Мои Списания", "WriteOff"
        )
    )

    Column ( modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Выберите проект!")

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp), verticalArrangement = Arrangement.Center
        ) {
            items(2) {
                AddIncubatorCard()
            }
        }
    }

}

@Composable
fun AddIncubatorCard() {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
//                navController.navigate("MyFerma")
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
                painter = painterResource(id = R.drawable.chicken),
                contentDescription = null,
                contentScale = ContentScale.Fit,

            )
            Text(
                text = "Инкубатор",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(vertical = 5.dp, horizontal = 5.dp)
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun AddIncubatorCardPrewie() {
    AddIncubatorCard()
}

//@Preview(showBackground = true)
//@Composable
//fun AddProjectCardPrewie() {
//    AddProjectCard()
//}

@Preview(showBackground = true)
@Composable
fun ChooiseProjectPrewie() {
    ChooiseProjectContainer(modifier = Modifier.fillMaxSize())
}

//@Preview(showBackground = true)
//@Composable
//fun AddProductSheetPrewie() {
//    AddProductSheet(showBottom = remember { mutableStateOf(false) })
//}