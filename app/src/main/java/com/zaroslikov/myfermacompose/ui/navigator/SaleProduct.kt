package com.zaroslikov.myfermacompose.ui.navigator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zaroslikov.myfermacompose.ui.TopAppBar
import kotlinx.coroutines.CoroutineScope

@Composable
fun SaleProduct(scope: CoroutineScope, drawerState: DrawerState) {
    val showBottomSheet = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(title = "Добавления", scope = scope, drawerState = drawerState)

        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { /* do something */ },
                icon = { Icon(Icons.Filled.Add, "Localized description") },
                text = { Text(text = "Добавить") },
            )
        }
    ) { innerPadding ->
        SaleProductContainer(
            modifier = Modifier.padding(innerPadding),
            showBottom = showBottomSheet
        )
    }
}
//
//@Composable
//fun SaleProductContainer() {
//    Card(
//        modifier = Modifier
//            .padding(8.dp)
//            .clickable {
////                navController.navigate("MyFerma")
//            },
//        elevation = CardDefaults.cardElevation(10.dp),
//        colors = CardDefaults.cardColors()
//    ) {
//        //clikable
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//
//            Column {
//                Text(
//                    text = "Яйца",
//                    modifier = Modifier
//                        .fillMaxWidth(0.16f)
//                        .padding(6.dp)
//                )
//
//                Text(
//                    text = "Дата добавления: 02.05.2024",
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier
//                        .wrapContentSize()
//                        .padding(6.dp)
//                )
//            }
//
//            Text(
//                text = "30",
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth(0.3f)
//                    .padding(6.dp)
//            )
//        }
//    }
//}

@Composable
fun SaleProductContainer(modifier: Modifier, showBottom: MutableState<Boolean>) {

    LazyVerticalGrid(columns = GridCells.Fixed(1)) {
        items(30) {
            AddProductCard()
        }
    }

    if (showBottom.value) {
        SaleProductSheet(
            showBottom = showBottom
        )
    }

}

@Composable
fun SaleProductSheet(showBottom: MutableState<Boolean>) {
    val checkedState = remember { mutableStateOf(false) }
    var text by rememberSaveable { mutableStateOf("") }
    Column(modifier = Modifier.padding(5.dp, 5.dp)) {
        Text(text = "Cейчас на складе: ${"Яйца - 50 шт."}", fontSize = 20.sp)
        Text(text = "Цена за 1 шт. товара : ${"Яйца 0.0 ₽"}", fontSize = 20.sp)

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Товар") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Выберите товар")
            }
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Количество") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите кол-во товара, которое хотите сохранить на склад")
            },
            suffix = { Text(text = "₽") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it }
            )
            Text(text = "Указать свою цену")
        }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Цена") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите цену за весь товар")
            },
            suffix = { Text(text = "₽") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "График")
                //TODO Изображение
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Продать")
                //TODO Изображение
            }
        }
    }

}

@Composable
fun SaleProductCard() {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
//                navController.navigate("MyFerma")
            },
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors()
    ) {
        //clikable

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {
                Text(
                    text = "Яйца",
                    modifier = Modifier
                        .fillMaxWidth(0.16f)
                        .padding(6.dp)
                )

                Text(
                    text = "Дата добавления: 02.05.2024",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(6.dp)
                )
            }

            Text(
                text = "30",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .padding(6.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SaleProductCardPrewie() {
    SaleProductCard()
}


//@Preview(showBackground = true)
//@Composable
//fun SaleProductPrewie() {
//    SaleProductSheet(modifier = Modifier.fillMaxSize())
//}