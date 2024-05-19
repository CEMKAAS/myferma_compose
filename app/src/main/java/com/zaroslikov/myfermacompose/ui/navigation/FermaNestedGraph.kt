package com.zaroslikov.myfermacompose.ui.navigation

import androidx.compose.material3.DrawerState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.zaroslikov.myfermacompose.ui.navigator.AddProduct
import com.zaroslikov.myfermacompose.ui.navigator.Expenses
import com.zaroslikov.myfermacompose.ui.navigator.Finance
import com.zaroslikov.myfermacompose.ui.navigator.SaleProduct
import com.zaroslikov.myfermacompose.ui.navigator.WareHouse
import com.zaroslikov.myfermacompose.ui.navigator.WriteOffProduct

fun NavGraphBuilder.fermaGraph(
    navController: NavController, drawerState: DrawerState
) {

    navigation(
        startDestination = Screens.ScreenWareHouseRoute.route,
        route = Screens.FermaRoute.route
    ) {

        composable(route = Screens.ScreenWareHouseRoute.route) {
            WareHouse(
                navController = navController,
                drawerState = drawerState
            )
        }

        composable(route = Screens.ScreenFinanceRoute.route) {
            Finance(
                navController = navController,
                drawerState = drawerState
            )
        }

        composable(route = Screens.ScreenAddRoute.route) {
            AddProduct(
                navController = navController,
                drawerState = drawerState
            )
        }
        composable(route = Screens.ScreenSaleRoute.route) {
            SaleProduct(
                navController = navController,
                drawerState = drawerState
            )
        }
        composable(route = Screens.ScreenWriteOffRoute.route) {
            WriteOffProduct(
                navController = navController,
                drawerState = drawerState
            )
        }
        composable(route = Screens.ScreenExpensesRoute.route) {
            Expenses(
                navController = navController,
                drawerState = drawerState
            )
        }

    }
}