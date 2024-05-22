package com.zaroslikov.myfermacompose.ui.navigator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zaroslikov.myfermacompose.data.ferma.AddTable
import com.zaroslikov.myfermacompose.ui.AppViewModelProvider
import com.zaroslikov.myfermacompose.ui.DrawerSheet
import com.zaroslikov.myfermacompose.ui.FilterProductSheet
import com.zaroslikov.myfermacompose.ui.TopAppBarFerma
import com.zaroslikov.myfermacompose.ui.navigation.NavigationDestination
import com.zaroslikov.myfermacompose.ui.navigation.Screens


object AddProductDestination : NavigationDestination {
    override val route = Screens.ScreenAddRoute.route
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProduct(
    navController: (String) -> Unit, drawerState: DrawerState,
    viewModel: AddProductViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val scope = rememberCoroutineScope()
//запоминает состояние для BottomSheet
    val sheetState = rememberModalBottomSheetState()
    val showBottomSheet = remember { mutableStateOf(false) }
    val showBottomSheetFilter = remember { mutableStateOf(false) }

    val idProject = viewModel.itemId

//    val addProductList by viewModel.uiState().collectAsState(emptyList())

    val itemsList = viewModel.sd.collectAsState(initial = emptyList())


        ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerSheet(
                scope = scope,
                navController = navController,
                drawerState = drawerState,
                3,
                idProject.toString()
            )
        },
    ) {
        Scaffold(
            topBar = {
                TopAppBarFerma(
                    title = "Мои Товары",
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
            AddProductContainer(
                modifier = Modifier.padding(innerPadding),
                showBottom = showBottomSheet,
                showBottomFilter = showBottomSheetFilter,
//                addProduct = addProductList,
//                insertAddTable = {
//                    scope.launch {
//                        viewModel.insertAddTable(
//                            AddTable(
//                                id = it.id,
//                                title = it.title,
//                                count = it.count,
//                                day = it.day,
//                                mount = it.mount,
//                                year = it.year,
//                                priceAll = it.priceAll,
//                                idPT = idProject
//                            )
//                        )
//                    }
//                },
                insertAddTable2 = {
                    viewModel.insertIt()
                },
                view = viewModel.itemUiState,
                itemsList = itemsList
            )
        }
    }
}

@Composable
fun AddProductContainer(
    modifier: Modifier,
    showBottom: MutableState<Boolean>,
    showBottomFilter: MutableState<Boolean>,
//    addProduct: List<AddTable>,
//    insertAddTable: (AddTableInsert) -> Unit,
    insertAddTable2: () -> Unit,
    view: AddDetails,
    itemsList: State<List<AddTable>>
) {

    LazyColumn(modifier = modifier) {
        items(itemsList.value) {
            AddProductCard(addProduct = it)
        }
    }

    if (showBottomFilter.value) {
        FilterProductSheet(
            showBottom = showBottomFilter
        )
    }

    if (showBottom.value) {
        AddProductSheet(
            showBottom = showBottom,
//            insertAddTable = insertAddTable,
            insertAddTable2 = insertAddTable2,
            view = view
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductSheet(
    showBottom: MutableState<Boolean>,
//    insertAddTable: (AddTableInsert) -> Unit,
    insertAddTable2: () -> Unit,
    view: AddDetails
) {
    //запоминает состояние для BottomShee

    ModalBottomSheet(onDismissRequest = { showBottom.value = false }) {
        var title by rememberSaveable { mutableStateOf("") }
        var count by rememberSaveable { mutableStateOf("") }

        Column(modifier = Modifier.padding(5.dp, 5.dp)) {
            Text(text = "Cейчас на складе: ${"Яйца - 50 шт."}", fontSize = 20.sp)

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Товар") },
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    Text("Введите или выберите товар")
                }
            )

            OutlinedTextField(
                value = count,
                onValueChange = { count = it },
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
                Button(onClick = {
//                    val calendar = Calendar.getInstance()
//                    insertAddTable(
//                        AddTableInsert(
//                            id = 0,
//                            title = title,
//                            count = count.toDouble(),
//                            calendar[Calendar.DAY_OF_MONTH],
//                            (calendar[Calendar.MONTH] + 1),
//                            calendar[Calendar.YEAR],
//                            priceAll = "0"
//                        )
//                    )
                    view.copy(title = title, count = count.toDouble())
                    insertAddTable2()
                }) {
                    Text(text = "Добавить")
                    //TODO Изображение
                }
            }
        }
    }
}


@Composable
fun AddProductCard(

    addProduct: AddTable
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
//                navController.navigate("OneEditAdd")
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
                    text = addProduct.title,
                    modifier = Modifier
                        .fillMaxWidth(0.16f)
                        .padding(6.dp),
                    fontWeight = FontWeight.SemiBold,
                )

                Text(
                    text = "${addProduct.day}.${addProduct.mount}.${addProduct.year}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(6.dp)
                )
            }

            Text(
                text = "${addProduct.count} шт.",
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


data class AddTableInsert(
    var id: Int,
    var title: String,
    var count: Double,
    var day: Int,
    var mount: Int,
    var year: Int,
    var priceAll: String
)

//@Preview(showBackground = true)
//@Composable
//fun AddProductCardPrewie() {
//    AddProductCard()
//}


//@Preview(showBackground = true)
//@Composable
//fun AddProductPrewie() {
//    AddProductContainer(
//        modifier = Modifier.fillMaxSize(),
//        showBottom = remember { mutableStateOf(false) })
//}

//@Preview(showBackground = true)
//@Composable
//fun AddProductSheetPrewie() {
//    AddProductSheet(showBottom = remember { mutableStateOf(true) })
//}