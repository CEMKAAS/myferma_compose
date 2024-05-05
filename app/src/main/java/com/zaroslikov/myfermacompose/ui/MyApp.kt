package com.zaroslikov.myfermacompose.ui


import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.zaroslikov.myfermacompose.R
import com.zaroslikov.myfermacompose.ui.navigation.Nav
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppFerma() {
    val navController: NavHostController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerSheet(scope = scope, navController = navController, drawerState = drawerState)
        },
    ) {
        Nav(navController = navController, scope = scope, drawerState = drawerState)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(title: String, scope: CoroutineScope, drawerState: DrawerState) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.largeTopAppBarColors(
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(text = title)
        },
        navigationIcon = {
            if (title != "Мое Хозяйство") {
                IconButton(onClick = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Localized description"
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Localized description"
                )
            }
        }
    )
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun StartTopAppBar(title: String, scope: CoroutineScope, drawerState: DrawerState) {
//    CenterAlignedTopAppBar(
//        colors = TopAppBarDefaults.largeTopAppBarColors(
//            titleContentColor = MaterialTheme.colorScheme.primary,
//        ),
//        title = {
//            Text(text = title)
//        },
//        navigationIcon = {
//
//            IconButton(onClick = {
//                scope.launch {
//                    drawerState.apply {
//                        if (isClosed) open() else close()
//                    }
//                }
//            }) {
//                Icon(
//                    imageVector = Icons.Filled.Menu,
//                    contentDescription = "Localized description"
//                )
//            }
//        },
//        actions = {
//            IconButton(onClick = {}) {
//                Icon(
//                    imageVector = Icons.Filled.Settings,
//                    contentDescription = "Localized description"
//                )
//            }
//        }
//    )
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MyAppFerma() {
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//
//    ModalNavigationDrawer(
//        drawerState = drawerState,
//        drawerContent = {
//            DrawerSheet()
//        },
//    ) {
//        CenterAlignedTopAppBar(
//            colors = TopAppBarDefaults.largeTopAppBarColors(
//                titleContentColor = MaterialTheme.colorScheme.primary,
//            ),
//            title = {
//                Text(text = "Мой Склад")
//
//            },
//            navigationIcon = {
//                IconButton(onClick = {
//                    scope.launch {
//                        drawerState.apply {
//                            if (isClosed) open() else close()
//                        }
//                    }
//                }) {
//                    Icon(
//                        imageVector = Icons.Filled.Menu,
//                        contentDescription = "Localized description"
//                    )
//                }
//            },
//            actions = {
//                IconButton(onClick = {}) {
//                    Icon(
//                        imageVector = Icons.Filled.Settings,
//                        contentDescription = "Localized description"
//                    )
//                }
//            },
//        )
//    }
//}


@Composable
fun DrawerSheet(scope: CoroutineScope, navController: NavController, drawerState: DrawerState) {
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


    var selectedItem by remember {
        mutableStateOf(drawerItems[0])
    }

    ModalDrawerSheet() {

//        Row(
//            modifier = Modifier
//                .padding(vertical = 10.dp)
//                .padding(start = 15.dp),
//            horizontalArrangement = Arrangement.Start,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.ic_action_name),
//                contentDescription = null,
//                modifier = Modifier.size(40.dp)
//            )
//            Text("Мое Хозяйство", modifier = Modifier.padding(16.dp), fontSize = 16.sp)
//        }
//
//        Divider()

        drawerItems.forEach {
            NavigationDrawerItem(
                label = { Text(text = it.text) },
                selected = it == selectedItem,
                icon = {
                    Image(painter = painterResource(id = it.icon), contentDescription = it.text)
                },
                onClick = {
                    selectedItem = it
                    scope.launch {
                        navController.navigate(it.route)
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }
            )
        }
    }
}


data class DrawerItems(
    val icon: Int,
    val text: String,
    val route: String
)


@Preview(showBackground = true)
@Composable
fun DrawerSheetPrewie(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    scope: CoroutineScope = rememberCoroutineScope()
) {
    DrawerSheet(scope = scope, navController = navController, drawerState = drawerState)
}


//@Preview(showBackground = true)
//@Composable
//fun MyAppPrewie() {
//    MyApp()
//}