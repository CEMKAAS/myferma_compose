package com.zaroslikov.myfermacompose.ui.navigator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.zaroslikov.myfermacompose.ui.DrawerSheet
import com.zaroslikov.myfermacompose.ui.TopAppBarFerma


@Composable
fun WareHouse(
    navController: NavController, drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()
    val showBottomSheetFilter = remember { mutableStateOf(false) }


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
            ContainerApp(modifier = Modifier.padding(innerPadding))
        }
    }
}


@Composable
fun ContainerApp(modifier: Modifier) {
    val items = listOf(
        "Яйца",
        "Молоко",
        "Мясо",
        "Пизда",
        "Яйца",
        "Молоко",
        "Мясо",
        "Пизда",
        "Молоко",
        "Мясо",
        "Пизда",
        "Яйца",
        "Молоко",
        "Мясо",
        "Пизда",
        "Молоко",
        "Мясо",
        "Пизда",
        "Яйца",
        "Молоко",
        "Мясо",
        "Пизда",
        "Молоко",
        "Мясо",
        "Пизда",
        "Яйца",
        "Молоко",
        "Мясо",
        "Пизда",
        "Молоко",
        "Мясо",
        "Пизда",
        "Яйца",
        "Молоко",
        "Мясо",
        "Пизда"
    )

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Сейчас на складе: ", fontSize = 25.sp, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        LazyColumn(
        ) {
            items(items) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = it, fontSize = 20.sp, modifier = Modifier.fillMaxWidth(0.3f))
                    Text(
                        text = "0",
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

@Preview(showBackground = true)
@Composable
fun ContainerPrewie() {
    ContainerApp(modifier = Modifier.fillMaxSize())
}