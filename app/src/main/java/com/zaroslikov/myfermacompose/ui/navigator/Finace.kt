package com.zaroslikov.myfermacompose.ui.navigator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
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


@Composable
fun Finance(
    navController: NavController, drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()
    val showBottomSheetFilter = remember { mutableStateOf(false) }
    Scaffold(
//        topBar = {
//            TopAppBar(title = "Мои Финансы", scope = scope, drawerState = drawerState, showBottomSheetFilter)
//        }
    ) { innerPadding ->
        FinanceApp(modifier = Modifier
            .padding(innerPadding)
            .fillMaxHeight(),)
    }
}


@Composable
fun FinanceApp(modifier: Modifier) {
    val items2 = listOf("Яйца", "Молоко", "Мясо", "Пизда", "Молоко", "Мясо", "Пизда", "Молоко", "Мясо", "Пизда", "Молоко", "Мясо", "Пизда", "Молоко", "Мясо", "Пизда")

    LazyColumn(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        item {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "За весь период: ",
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 10.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Общая сумма",
                        fontSize = 20.sp,
                        modifier = Modifier.fillMaxWidth(0.42f)
                    )
                    Text(
                        text = "150 000,00",
                        fontSize = 20.sp,
                        modifier = Modifier.fillMaxWidth(0.5f),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = " ₽", fontSize = 20.sp
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Расходы",
                        fontSize = 20.sp,
                        modifier = Modifier.fillMaxWidth(0.42f)
                    )
                    Text(
                        text = "150 000,00",
                        fontSize = 20.sp,
                        modifier = Modifier.fillMaxWidth(0.5f),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = " ₽", fontSize = 20.sp
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Чистая прибыль:",
                        fontSize = 20.sp,
                        modifier = Modifier.fillMaxWidth(0.42f)
                    )
                    Text(
                        text = "150 000,00",
                        fontSize = 20.sp,
                        modifier = Modifier.fillMaxWidth(0.5f),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = " ₽", fontSize = 20.sp
                    )
                }

                Spacer(modifier = Modifier.padding(vertical = 5.dp))

                Text(
                    text = "Продали продукции:",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )

            }
        }

        items(items2) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Продали $it",
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth(0.45f)
                )
                Text(
                    text = "150 000.00",
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth(0.5f),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = " ₽", fontSize = 20.sp
                )
            }
        }

        item {
            Text(
                text = "Сэкономлено продукции:",
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }

        items(items2) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Продали $it",
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth(0.45f)
                )
                Text(
                    text = "150 000.00",
                    fontSize = 20.sp,
                    modifier = Modifier.fillMaxWidth(0.5f),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = " ₽", fontSize = 20.sp
                )
            }
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun FinancePrewie() {
//    Finance(scope = rememberCoroutineScope(), drawerState =  rememberDrawerState(initialValue = DrawerValue.Closed))
//}

@Preview(showBackground = true)
@Composable
fun FinanceContainerPrewie() {
    FinanceApp(modifier = Modifier.fillMaxSize())
}

