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
            TopAppBar(title = "Мои Продажи", scope = scope, drawerState = drawerState)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { showBottomSheet.value = true },
                icon = { Icon(Icons.Filled.Add, "Продать") },
                text = { Text(text = "Продать") },
            )
        }
    ) { innerPadding ->
        SaleProductContainer(
            modifier = Modifier.padding(innerPadding),
            showBottom = showBottomSheet
        )
    }
}

@Composable
fun SaleProductContainer(modifier: Modifier, showBottom: MutableState<Boolean>) {

    LazyVerticalGrid(columns = GridCells.Fixed(1), modifier = modifier) {
        items(30) {
            SaleProductCard()
        }
    }

    if (showBottom.value) {
        SaleProductSheet(
            showBottom = showBottom
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaleProductSheet(showBottom: MutableState<Boolean>) {
    val checkedState = remember { mutableStateOf(false) }
    var text by rememberSaveable { mutableStateOf("") }

    //TODO щит выдвигается полностью
    ModalBottomSheet(onDismissRequest = { showBottom.value = false }) {
        Column(modifier = Modifier.padding(5.dp, 5.dp)) {
            Text(text = "Cейчас на складе: ${"Яйца - 50 шт."}", fontSize = 20.sp)
            Text(text = "Цена за 1 шт. товара : ${"Яйца 0.0 ₽"}", fontSize = 20.sp)

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Товар") },
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    Text("Введите или выберите товар")
                }
            )

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Количество") },
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    Text("Укажите кол-во товара, которое Вы продали")
                },
                suffix = { Text(text = "₽") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
            )

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
                    text = "Дата: 02.05.2024",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(6.dp)
                )
            }

            Text(
                text = "30",
                textAlign = TextAlign.Center,
            )

            Text(
                text = "30 ₽",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(6.dp)
                    .padding(end = 10.dp)
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