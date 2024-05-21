package com.zaroslikov.myfermacompose.ui.navigation

sealed class Screens(val route: String){
    object ScreenStartRoute : Screens(route = "Start")
    object ScreenChoiseRoute : Screens(route = "ChooiseProject")
    object ScreenProjectRoute : Screens(route = "AddIncubator")
    object ScreenOneIncubatorAddRoute : Screens(route = "Ferma")
    object ScreenTwoIncubatorAddRoute : Screens(route = "Ferma")



    object ScreenWareHouseRoute : Screens(route = "WareHouse")

    object ScreenAddRoute : Screens(route = "Add")
    object ScreenSaleRoute : Screens(route = "Sale")
    object ScreenWriteOffRoute : Screens(route = "WriteOff")
    object ScreenExpensesRoute : Screens(route = "Expenses")


    object ScreenFinanceRoute : Screens(route = "Finance")
    object ScreenAnimalRoute : Screens(route = "Animal")

    object StartRoute : Screens(route = "StarA")
    object FermaRoute : Screens(route = "App")
}