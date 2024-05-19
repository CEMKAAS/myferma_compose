package com.zaroslikov.myfermacompose.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.zaroslikov.myfermacompose.ui.StartScreen
import com.zaroslikov.myfermacompose.ui.add.AddChoice
import com.zaroslikov.myfermacompose.ui.add.AddIncubator
import com.zaroslikov.myfermacompose.ui.add.AddIncubatorTwo
import com.zaroslikov.myfermacompose.ui.add.AddProject

fun NavGraphBuilder.startGraph(navController: NavController) {

    navigation(startDestination = Screens.ScreenStartRoute.route, route = Screens.StartRoute.route) {
        composable(route = Screens.ScreenStartRoute.route) {
            StartScreen(navController = navController)
        }

        composable(route = Screens.ScreenChoiseRoute.route) {
            AddChoice(
                navController = navController,
                navigateBack = { navController.popBackStack() })
        }
        composable(route = Screens.ScreenProjectRoute.route) {
            AddProject(
                navController = navController,
                navigateBack = { navController.popBackStack() })
        }
        composable(route = Screens.ScreenOneIncubatorAddRoute.route) {
            AddIncubator(
                navController = navController,
                navigateBack = { navController.popBackStack() })
        }
        composable(route = Screens.ScreenTwoIncubatorAddRoute.route) {
            AddIncubatorTwo(
                navController = navController,
                navigateBack = { navController.popBackStack() })
        }
    }
}