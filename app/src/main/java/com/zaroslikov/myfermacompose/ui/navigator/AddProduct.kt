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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zaroslikov.myfermacompose.data.ferma.AddTable
import com.zaroslikov.myfermacompose.ui.AppViewModelProvider
import com.zaroslikov.myfermacompose.ui.navigation.NavigationDestination
import com.zaroslikov.myfermacompose.ui.navigation.Screens
import kotlinx.coroutines.launch


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
////запоминает состояние для BottomSheet
//    val sheetState = rememberModalBottomSheetState()
//    val showBottomSheet = remember { mutableStateOf(false) }
//    val showBottomSheetFilter = remember { mutableStateOf(false) }

//    val idProject = viewModel.itemId

//    val addProductList by viewModel.uiState().collectAsState(emptyList())

//    val itemsList by viewModel.sd.collectAsState()

//    var noteList by remember {
//        mutableStateOf(listOf<AddTable>())
//    }
//
//    viewModel.getTable().observe(this) {
//        noteList = it
//    }

//    val todoList by viewModel.todoList.observeAsState()

//    viewModel.uiState2.observe(con, Observer {
//        items -> {}
//    })



//    val itemsListNeco by viewModel.itemNeco().collectAsState(initial = emptyList())

    val homeState = viewModel.state

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Button(onClick = {
                scope.launch {
                    viewModel.insertNeco()
                }

                homeState.itemList
            }) {
                Text(text = "sd")
            }
        }
        items(homeState.itemList) { itemsList ->
            AddProductCard(addProduct = itemsList)
        }
    }

//    ModalNavigationDrawer(
//        drawerState = drawerState,
//        drawerContent = {
//            DrawerSheet(
//                scope = scope,
//                navController = navController,
//                drawerState = drawerState,
//                3,
//                idProject.toString()
//            )
//        },
//    ) {
//        Scaffold(
//            topBar = {
//                TopAppBarFerma(
//                    title = "Мои Товары",
//                    scope = scope,
//                    drawerState = drawerState,
//                    showBottomFilter = showBottomSheetFilter,
//                    filterSheet = true
//                )
//            },
//            floatingActionButton = {
//                ExtendedFloatingActionButton(
//                    onClick = {
////                        showBottomSheet.value = true
//
////                        scope.launch {
////                            viewModel.addItem2(
////                                AddTable(
////                                    id = 0,
////                                    title = "dsd",
////                                    count = 0.0,
////                                    calendar[Calendar.DAY_OF_MONTH],
////                                    (calendar[Calendar.MONTH] + 1),
////                                    calendar[Calendar.YEAR],
////                                    priceAll = "0",
////                                    idPT = idProject
////                                )
////                            )
////                        }
//
////                        viewModel.insertIt()
//
//                        viewModel.insertNeco()
//
//                    },
//                    icon = { Icon(Icons.Filled.Add, "Добавить") },
//                    text = { Text(text = "Добавить") },
//                )
//            }
//        ) { innerPadding ->
//                AddProductContainer(
//                    modifier = Modifier.padding(innerPadding),
//                    showBottom = showBottomSheet,
//                    showBottomFilter = showBottomSheetFilter,
//        //                addProduct = addProductList,
//                    insertAddTable = {
//
//                    },
//                    viewModel = viewModel,
//        //                insertAddTable2 = {
//        //                    viewModel.insertIt()
//        //                },
//        //                view = viewModel.itemUiState,
//                    itemsList = itemsListNeco
//
//        //                noteList
//        //                itemsList.itemList
//                )
//            }
}
//    }


@Composable
fun AddProductContainer(
    modifier: Modifier,
    showBottom: MutableState<Boolean>,
    showBottomFilter: MutableState<Boolean>,
//    addProduct: List<AddTable>,
    insertAddTable: (AddTableInsert) -> Unit,
    viewModel: AddProductViewModel,
//    insertAddTable2: () -> Unit,
//    view: AddDetails,
//    itemsList: List<AddTable>
    itemsList: State<List<AddTable>>
) {

    LazyColumn(modifier = modifier) {
        items(itemsList.value) { itemsList ->
            AddProductCard(addProduct = itemsList)
        }
    }

//    if (showBottomFilter.value) {
//        FilterProductSheet(
//            showBottom = showBottomFilter
//        )
//    }
//
//    if (showBottom.value) {
//        AddProductSheet(
//            showBottom = showBottom,
//            insertAddTable = insertAddTable,
//            insertAddTable2 = insertAddTable2,
//            view = view
//        )
//    }

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

//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AddProductSheet(
//    showBottom: MutableState<Boolean>,
//    insertAddTable: (AddTableInsert) -> Unit,
////    insertAddTable2: () -> Unit,
////    view: AddDetails
//) {
//    //запоминает состояние для BottomShee
//
//    ModalBottomSheet(onDismissRequest = { showBottom.value = false }) {
//        var title by rememberSaveable { mutableStateOf("") }
//        var count by rememberSaveable { mutableStateOf("") }
//
//        Column(modifier = Modifier.padding(5.dp, 5.dp)) {
//            Text(text = "Cейчас на складе: ${"Яйца - 50 шт."}", fontSize = 20.sp)
//
//            OutlinedTextField(
//                value = title,
//                onValueChange = { title = it },
//                label = { Text("Товар") },
//                modifier = Modifier.fillMaxWidth(),
//                supportingText = {
//                    Text("Введите или выберите товар")
//                }
//            )
//
//            OutlinedTextField(
//                value = count,
//                onValueChange = { count = it },
//                label = { Text("Количество") },
//                modifier = Modifier.fillMaxWidth(),
//                supportingText = {
//                    Text("Укажите кол-во товара, которое хотите сохранить на склад")
//                },
//                suffix = { Text(text = "Шт.") },
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
////            isError = () TODO
//            )
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 10.dp),
//                horizontalArrangement = Arrangement.Center
//            ) {
//                Button(onClick = {
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
//                    view.sd
////                    insertAddTable2()
//                }) {
//                    Text(text = "Добавить")
//                    //TODO Изображение
//                }
//            }
//        }
//    }
//}

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