package com.zaroslikov.myfermacompose.ui.navigator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zaroslikov.myfermacompose.ui.TopAppBar
import kotlinx.coroutines.CoroutineScope

@Composable
fun SaleProduct(scope: CoroutineScope, drawerState: DrawerState) {
    Scaffold(
        topBar = {
            TopAppBar(title = "Добавления", scope = scope, drawerState = drawerState)

        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { /* do something */ },
                icon = { Icon(Icons.Filled.Add, "Localized description") },
                text = { Text(text = "Добавить") },
            )
        }
    ) { innerPadding ->
        SaleProductSheet(modifier = Modifier.padding(innerPadding))
    }
}



@Composable
fun SaleProductSheet(modifier: Modifier) {
    val checkedState = remember { mutableStateOf(false) }
    var text by rememberSaveable { mutableStateOf("") }
    Column(modifier = modifier.padding(5.dp, 5.dp)) {
        Text(text = "Cейчас на складе: ${"Яйца - 50 шт."}", fontSize = 20.sp)
        Text(text = "Цена за 1 шт. товара : ${"Яйца 0.0 ₽"}", fontSize = 20.sp)

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Товар") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Выберите товар")
            }
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Количество") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите кол-во товара, которое хотите сохранить на склад")
            },
            suffix = { Text(text = "₽") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it }
            )
            Text(text = "Указать свою цену")
        }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Цена") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите цену за весь товар")
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
                Text(text = "Продать")
                //TODO Изображение
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun SaleProductPrewie() {
    SaleProductSheet(modifier = Modifier.fillMaxSize())
}