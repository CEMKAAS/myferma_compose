package com.zaroslikov.myfermacompose.ui.navigator


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController





@Composable
fun Expenses(modifier:Modifier) {
    var text by rememberSaveable { mutableStateOf("") }
    Column(modifier = modifier.padding(5.dp, 5.dp)) {
        Text(text = "Ваш баланс составляет: ${"0.00 ₽"}", fontSize = 20.sp)

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Введите товар") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Выберите или введите товар")
            }
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Цена") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите цену за купленный товар")
            },
            suffix = { Text(text = "₽") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "График")
                //TODO Изображение
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Добавить")
                //TODO Изображение
            }
        }


    }

}


@Preview(showBackground = true)
@Composable
fun ExpensesPrewie() {
    Expenses(modifier = Modifier.fillMaxSize())
}