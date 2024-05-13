package com.zaroslikov.myfermacompose.ui.navigator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zaroslikov.myfermacompose.R
import com.zaroslikov.myfermacompose.ui.TopAppBarStart


@Composable
fun OneCardEdit(
    title:String,
    navController: NavController, navigateBack: () -> Unit, price: Boolean,
    status: Boolean,
    route: String
) {

    Scaffold(
        topBar = {
            TopAppBarStart(title = title, true, navigateUp = navigateBack)
        },
    ) { innerPadding ->
        OneCardEditContainer(
            modifier = Modifier.padding(innerPadding),
            navController = navController, price = price,
            status = status, route = route
        )
    }
}


@Composable
fun OneCardEditContainer(
    modifier: Modifier,
    navController: NavController, price: Boolean,
    status: Boolean,
    route: String
) {
    var text by rememberSaveable { mutableStateOf("") }
    Column(modifier = modifier.padding(5.dp, 5.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Товар") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Введите или выберите товар")
            }
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Количество") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите кол-во товара")
            },
            suffix = { Text(text = "Шт.") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )

        if (price) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Цена") },
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    Text("Укажите цену")
                },
                suffix = { Text(text = "₽") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
            )
        }

        if (status) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Статус") },
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    Text("Выберите статус")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
            )
        }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Дата") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите дату")
            },
            trailingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.baseline_calendar_month_24),
                    contentDescription = "Период"
                )
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Обновить")
                //TODO Изображение
            }
            Button(onClick = { navController.navigate(route) }) {
                Text(text = "Удалить")

            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun OneCardEditContainerPrewie() {
//    OneCardEditContainer(modifier = Modifier.fillMaxSize(), )
//}


@Preview(showBackground = true)
@Composable
fun OneCardEditPrewie() {
    OneCardEdit(navController = rememberNavController(), navigateBack = {}, status = true, price = true, route = "Add", title = "Мои Товары")
}

