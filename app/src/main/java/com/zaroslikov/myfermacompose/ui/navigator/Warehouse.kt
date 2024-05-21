package com.zaroslikov.myfermacompose.ui.navigator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zaroslikov.myfermacompose.data.WareHouseData
import com.zaroslikov.myfermacompose.ui.AppViewModelProvider
import com.zaroslikov.myfermacompose.ui.DrawerSheet
import com.zaroslikov.myfermacompose.ui.TopAppBarFerma
import com.zaroslikov.myfermacompose.ui.navigation.NavigationDestination
import com.zaroslikov.myfermacompose.ui.navigation.Screens


object ItemDetailsDestination : NavigationDestination {
    override val route = Screens.ScreenWareHouseRoute.route
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@Composable
fun WareHouse(
    navController: (String) -> Unit, drawerState: DrawerState,
    viewModel: WarehouseViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val scope = rememberCoroutineScope()
    val showBottomSheetFilter = remember { mutableStateOf(false) }

    val countAD by viewModel.uiState().collectAsState(emptyList())

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerSheet(scope = scope, navController = navController, drawerState = drawerState, 1)
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBarFerma(
                    title = "Мой Склад",
                    scope = scope,
                    drawerState = drawerState,
                    showBottomFilter = showBottomSheetFilter,
                    filterSheet = true
                )
            },
        ) { innerPadding ->
            ContainerApp(modifier = Modifier.padding(innerPadding), warehouseList = countAD)
        }
    }
}


@Composable
fun ContainerApp(modifier: Modifier, warehouseList: List<WareHouseData>) {

    if (warehouseList.isEmpty()) {
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Упс, но Ваш склад пока пуст",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        }
    } else {
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Сейчас на складе: ", fontSize = 25.sp, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            LazyColumn{
                items(warehouseList) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = it.Title,
                            fontSize = 20.sp,
                            modifier = Modifier.fillMaxWidth(0.3f)
                        )
                        Text(
                            text = it.ResultCount.toString(),
                            fontSize = 20.sp,
                            modifier = Modifier.fillMaxWidth(0.1f),
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Шт.", fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ContainerPrewie() {
//    ContainerApp(modifier = Modifier.fillMaxSize())
//}