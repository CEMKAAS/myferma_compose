package com.zaroslikov.myfermacompose.ui.navigation

//import com.zaroslikov.myfermacompose.ui.add.ChooiseProject
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun Nav(
    navController: NavController,
    drawerState: DrawerState,
) {
   NavHost(navController = navController as NavHostController, startDestination = Screens.ScreenAddRoute.route){
//        startGraph(navController)
        fermaGraph(navController, drawerState)
    }
}




//    NavHost(navController = navController, startDestination = "Start") {
//
//        composable(route = "Start") {
//            StartScreen(navController = navController)
//        }
//
//        composable(route = "ChooiseProject") {
//            ChooiseProject(
//                navController = navController,
//                navigateBack = { navController.popBackStack() })
//        }
//
//        composable(route = "AddIncubator") {
//            AddIncubator(
//                navController = navController,
//                navigateBack = { navController.popBackStack() })
//        }
//
//        composable(route = "AddIncubatorTwo") {
//            AddIncubatorTwo(
//                navController = navController,
//                navigateBack = { navController.popBackStack() })
//        }
//        composable(route = "AddProject") {
//            AddProject(
//                navController = navController,
//                navigateBack = { navController.popBackStack() })
//        }
//        composable(route = "Ferma") {
//            Ferma()
//        }
////
//        composable(route = "Incubator") {
//            Incubator(navigateBack = { navController.popBackStack() })
//        }
////
////        composable(route = "Add") {
////            AddProduct(scope = scope, drawerState = drawerState, navController = navController, selectedItem = selectedItem)
////        }
////
////        composable(route = "Finance") {
////            Finance(scope = scope, drawerState = drawerState, selectedItem = selectedItem)
////        }
////
////        composable(route = "Sale") {
////            SaleProduct(
////                scope = scope,
////                drawerState = drawerState,
////                navController = navController,
////                selectedItem = selectedItem
////            )
////        }
////        composable(route = "Expenses") {
////            Expenses(scope = scope, drawerState = drawerState, navController = navController, selectedItem = selectedItem)
////        }
////
////        composable(route = "WriteOff") {
////            WriteOffProduct(scope = scope, drawerState = drawerState, navController = navController, selectedItem = selectedItem)
////        }
//
//
//    }
//}
//
//@Composable
//fun NavFerma(navController: NavHostController, scope: CoroutineScope, drawerState: DrawerState) {
//
//    NavHost(navController = navController, startDestination = "WareHouse") {
//
//        composable(route = "WareHouse") {
//            WareHouse(
//                scope = scope,
//                drawerState = drawerState,
//            )
//        }
//        composable(route = "Start") {
//            MyAppFerma()
//        }
//        composable(route = "Finance") {
//            Finance(scope = scope, drawerState = drawerState)
//        }
//
//        // ADD - Добавление
//        composable(route = "Add") {
//            AddProduct(scope = scope, drawerState = drawerState, navController = navController)
//        }
//
//        composable(route = "OneEditAdd") {
//            OneCardEdit(
//                navController = navController,
//                navigateBack = { navController.popBackStack() },
//                price = false,
//                status = false,
//                route = "Add",
//                title = "Мои Товары"
//            )
//        }
//
//        //Sale - Продажи
//        composable(route = "Sale") {
//            SaleProduct(scope = scope, drawerState = drawerState, navController = navController)
//        }
//
//        composable(route = "OneEditSale") {
//            OneCardEdit(
//                navController = navController,
//                navigateBack = { navController.popBackStack() },
//                price = true,
//                status = false,
//                route = "Sale",
//                title = "Мои Продажи"
//            )
//        }
//        // Expenses - Покупки
//        composable(route = "Expenses") {
//            Expenses(scope = scope, drawerState = drawerState, navController = navController)
//        }
//
//        composable(route = "OneEditExpenses") {
//            OneCardEdit(
//                navController = navController,
//                navigateBack = { navController.popBackStack() },
//                price = true,
//                status = false,
//                route = "Expenses",
//                title = "Мои Покупки"
//            )
//        }
//
//        // WriteOff - Списание
//        composable(route = "WriteOff") {
//            WriteOffProduct(scope = scope, drawerState = drawerState, navController = navController)
//        }
//
//        composable(route = "OneEditWriteOff") {
//            OneCardEdit(
//                navController = navController,
//                navigateBack = { navController.popBackStack() },
//                price = false,
//                status = true,
//                route = "WriteOff",
//                title = "Мои Списания"
//            )
//        }
//        composable(route = "Animal") {
//            Animal(scope = scope, drawerState = drawerState, navController = navController)
//        }
//    }
//}
//
//
//@Composable
//fun NavIncubator(
//    navController: NavHostController,
//    scope: CoroutineScope,
//    drawerState: DrawerState
//) {
//
//    NavHost(navController = navController, startDestination = "IncubatorNow") {
//
////        composable(route = "IncubatorNow") {
////            NowIncubator(
////
////            )
////        }
//        composable(route = "Start") {
//            MyAppFerma()
//        }
//        composable(route = "Finance") {
//            Finance(scope = scope, drawerState = drawerState)
//        }
//
//        // ADD - Добавление
//        composable(route = "Add") {
//            AddProduct(scope = scope, drawerState = drawerState, navController = navController)
//        }
//
//        composable(route = "OneEditAdd") {
//            OneCardEdit(
//                navController = navController,
//                navigateBack = { navController.popBackStack() },
//                price = false,
//                status = false,
//                route = "Add",
//                title = "Мои Товары"
//            )
//        }
//
//        //Sale - Продажи
//        composable(route = "Sale") {
//            SaleProduct(scope = scope, drawerState = drawerState, navController = navController)
//        }
//
//        composable(route = "OneEditSale") {
//            OneCardEdit(
//                navController = navController,
//                navigateBack = { navController.popBackStack() },
//                price = true,
//                status = false,
//                route = "Sale",
//                title = "Мои Продажи"
//            )
//        }
//        // Expenses - Покупки
//        composable(route = "Expenses") {
//            Expenses(scope = scope, drawerState = drawerState, navController = navController)
//        }
//
//        composable(route = "OneEditExpenses") {
//            OneCardEdit(
//                navController = navController,
//                navigateBack = { navController.popBackStack() },
//                price = true,
//                status = false,
//                route = "Expenses",
//                title = "Мои Покупки"
//            )
//        }
//
//        // WriteOff - Списание
//        composable(route = "WriteOff") {
//            WriteOffProduct(
//                scope = scope,
//                drawerState = drawerState,
//                navController = navController
//            )
//        }
//
//        composable(route = "OneEditWriteOff") {
//            OneCardEdit(
//                navController = navController,
//                navigateBack = { navController.popBackStack() },
//                price = false,
//                status = true,
//                route = "WriteOff",
//                title = "Мои Списания"
//            )
//        }
//    }
//
//}
