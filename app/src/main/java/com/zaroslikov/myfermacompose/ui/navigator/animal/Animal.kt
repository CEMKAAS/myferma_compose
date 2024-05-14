package com.zaroslikov.myfermacompose.ui.navigator.animal

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zaroslikov.myfermacompose.ui.DrawerSheet
import com.zaroslikov.myfermacompose.ui.FilterProductSheet
import com.zaroslikov.myfermacompose.ui.TopAppBarFerma
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Animal(scope: CoroutineScope, drawerState: DrawerState, navController: NavController) {

//запоминает состояние для BottomSheet
    val sheetState = rememberModalBottomSheetState()
    val showBottomSheet = remember { mutableStateOf(false) }
    val showBottomSheetFilter = remember { mutableStateOf(false) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerSheet(scope = scope, navController = navController, drawerState = drawerState)
        },
    ) {
        Scaffold(
            topBar = {
                TopAppBarFerma(
                    title = "Мои Животные",
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
                    icon = { Icon(Icons.Filled.Add, "Добавить") },
                    text = { Text(text = "Добавить") },
                )
            }
        ) { innerPadding ->
            AnimalContainer(
                modifier = Modifier.padding(innerPadding),
                showBottom = showBottomSheet,
                showBottomFilter = showBottomSheetFilter,
                navController = navController
            )
        }
    }
}

@Composable
fun AnimalContainer(
    modifier: Modifier,
    showBottom: MutableState<Boolean>,
    showBottomFilter: MutableState<Boolean>,
    navController: NavController
) {

    LazyVerticalGrid(columns = GridCells.Fixed(1), modifier = modifier) {
        items(30) {
            AnimalCard(navController = navController)
        }
    }
    if (showBottomFilter.value) {
        FilterProductSheet(
            showBottom = showBottomFilter
        )
    }

    if (showBottom.value) {
        AddAnimalSheet(
            showBottom = showBottom
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAnimalSheet(
    showBottom: MutableState<Boolean>,
) {
    //запоминает состояние для BottomShee

//    ModalBottomSheet(onDismissRequest = { showBottom.value = false }) {
    var text by rememberSaveable { mutableStateOf("") }
    Column(modifier = Modifier.padding(5.dp, 5.dp)) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Имя") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите имя или группу животных")
            }
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Вес") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите кол-во товара, которое хотите сохранить на склад")
            },
            suffix = { Text(text = "Шт.") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Количество") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите кол-во товара, которое хотите сохранить на склад")
            },
            suffix = { Text(text = "Шт.") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Количество") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите кол-во товара, которое хотите сохранить на склад")
            },
            suffix = { Text(text = "Шт.") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Количество") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите кол-во товара, которое хотите сохранить на склад")
            },
            suffix = { Text(text = "Шт.") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Добавить")
                //TODO Изображение
            }
        }
    }
}
//}


@Composable
fun AnimalCard(navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                navController.navigate("OneEditAdd")
            },
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors()
    ) {
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

            Text(
                text = "30 шт.",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .padding(6.dp),
                fontWeight = FontWeight.Black,
                fontSize = 18.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AnimalCardPrewie() {
    AnimalCard(navController = rememberNavController())
}


@Preview(showBackground = true)
@Composable
fun AnimalPrewie() {
    Animal(
        scope = rememberCoroutineScope(),
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
        navController = rememberNavController()
    )
}

@Preview(showBackground = true)
@Composable
fun AddProductSheetPrewie() {
    AddAnimalSheet(showBottom = remember { mutableStateOf(true) })
}