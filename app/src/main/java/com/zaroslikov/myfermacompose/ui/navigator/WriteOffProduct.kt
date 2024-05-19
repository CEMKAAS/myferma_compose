package com.zaroslikov.myfermacompose.ui.navigator

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.selection.selectableGroup
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
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zaroslikov.myfermacompose.R
import com.zaroslikov.myfermacompose.ui.DrawerSheet
import com.zaroslikov.myfermacompose.ui.FilterProductSheet
import com.zaroslikov.myfermacompose.ui.TopAppBarFerma


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WriteOffProduct(
    navController: NavController, drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()
//запоминает состояние для BottomSheet
    val sheetState = rememberModalBottomSheetState()
    val showBottomSheet = remember { mutableStateOf(false) }
    val showBottomSheetFilter = remember { mutableStateOf(false) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerSheet(scope = scope, navController = navController, drawerState = drawerState,5)
        },
    ) {
        Scaffold(
            topBar = {
                TopAppBarFerma(
                    title = "Мои Списания",
                    scope = scope,
                    drawerState = drawerState,
                    showBottomFilter = showBottomSheetFilter,
                    filterSheet = true
                )
            },
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    onClick = {
                        showBottomSheet.value = true
                    },
                    icon = { Icon(Icons.Filled.Add, "Списать") },
                    text = { Text(text = "Списать") },
                )
            }
        ) { innerPadding ->
            WriteOffProductContainer(
                modifier = Modifier.padding(innerPadding),
                showBottom = showBottomSheet,
                showBottomFilter = showBottomSheetFilter,
                navController = navController
            )
        }
    }
}

@Composable
fun WriteOffProductContainer(
    modifier: Modifier, showBottom: MutableState<Boolean>,
    showBottomFilter: MutableState<Boolean>,
    navController: NavController
) {

    LazyVerticalGrid(columns = GridCells.Fixed(1), modifier = modifier) {
        items(30) {
            WriteOffProductCard(navController = navController)
        }
    }

    if (showBottomFilter.value) {
        FilterProductSheet(
            showBottom = showBottomFilter
        )
    }

    if (showBottom.value) {
        WriteOffProductSheet(
            showBottom = showBottom
        )
    }

}


@Composable
fun WriteOffProductCard(navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                navController.navigate("OneEditWriteOff")
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
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_delete_24),
                        contentDescription = "delete",
                        modifier = Modifier
                            .padding(6.dp)
                    )
                    Column {
                        Text(
                            text = "Яйца",
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(6.dp),
                            fontWeight = FontWeight.SemiBold,
                        )

                        Text(
                            text = "Дата: 02.05.2024",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(6.dp)
                        )
                    }
                }
            }
            Text(
                text = "30",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(end = 10.dp),
                fontWeight = FontWeight.Black,
                fontSize = 18.sp
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WriteOffProductSheet(showBottom: MutableState<Boolean>) {

    ModalBottomSheet(onDismissRequest = { showBottom.value = false }) {
        var state by remember { mutableStateOf(true) }

        var text by rememberSaveable { mutableStateOf("") }
        Column(modifier = Modifier.padding(5.dp, 5.dp)) {
            Text(text = "Cейчас на складе: ${"Яйца - 50 шт."}", fontSize = 20.sp)

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
                    Text("Укажите кол-во товара, которое хотите списать со склада")
                },
                suffix = { Text(text = "₽") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
            )

            Row(
                Modifier
                    .selectableGroup()
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = state,
                    onClick = { state = true },
                    modifier = Modifier.semantics { contentDescription = "Localized Description" }
                )
                Text(text = "На собственные нужды")
                RadioButton(
                    selected = !state,
                    onClick = { state = false },
                    modifier = Modifier.semantics { contentDescription = "Localized Description" }
                )
                Text(text = "На утилизацию")
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Продать")
                    //TODO Изображение
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun WriteOffProductPrewie() {
//    WriteOffProduct(modifier = Modifier.fillMaxSize())
//}

@Preview(showBackground = true)
@Composable
fun WriteOffProductPrewie() {
    WriteOffProductCard(navController = rememberNavController())
}