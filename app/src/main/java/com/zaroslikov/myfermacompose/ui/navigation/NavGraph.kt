package com.zaroslikov.myfermacompose.ui.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zaroslikov.myfermacompose.ui.Incubator.IncubatorStart
import com.zaroslikov.myfermacompose.ui.Incubator.NowIncubator
import com.zaroslikov.myfermacompose.ui.StartScreen
import com.zaroslikov.myfermacompose.ui.navigator.AddProduct
import com.zaroslikov.myfermacompose.ui.navigator.Container
import com.zaroslikov.myfermacompose.ui.navigator.ContainerApp
import com.zaroslikov.myfermacompose.ui.navigator.Expenses
import com.zaroslikov.myfermacompose.ui.navigator.Finance
import com.zaroslikov.myfermacompose.ui.navigator.SaleProduct
import com.zaroslikov.myfermacompose.ui.navigator.WriteOffProduct
import kotlinx.coroutines.CoroutineScope

@Composable
fun Nav(navController: NavHostController, scope: CoroutineScope, drawerState: DrawerState) {

    NavHost(navController = navController, startDestination = "Start") {

        composable(route = "Start") {
            StartScreen(scope = scope, drawerState = drawerState, navController)
        }

        composable(route = "MyFerma") {
            Container(scope = scope, drawerState = drawerState)
        }

        composable(route = "Add") {
            AddProduct(scope = scope, drawerState = drawerState)
        }

        composable(route = "Finance") {
            Finance(scope = scope, drawerState = drawerState)
        }

        composable(route = "Sale") {
            SaleProduct(scope = scope, drawerState = drawerState)
        }

        composable(route = "Expenses") {
            Expenses(scope = scope, drawerState = drawerState)
        }

        composable(route = "WriteOff") {
            WriteOffProduct(scope = scope, drawerState = drawerState)
        }

//
//        composable(route = "E") {
//            Finance(modifier = modifier)
//        }
//

    }
}