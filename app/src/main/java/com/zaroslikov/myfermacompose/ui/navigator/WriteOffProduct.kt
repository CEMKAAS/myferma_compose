package com.zaroslikov.myfermacompose.ui.navigator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WriteOffProduct(modifier: Modifier) {
    var state by remember { mutableStateOf(true) }

    var text by rememberSaveable { mutableStateOf("") }
    Column(modifier = modifier.padding(5.dp, 5.dp)) {
        Text(text = "Cейчас на складе: ${"Яйца - 50 шт."}", fontSize = 20.sp)

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Товар") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Выберите товар со склада")
            }
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Количество") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите кол-во товара, которое нужно списать со склада")
            },
            suffix = { Text(text = "₽") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )

        Row(Modifier.selectableGroup().fillMaxWidth()
            .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = state,
                onClick = { state = true },
                modifier = Modifier.semantics { contentDescription = "Localized Description" }
            )
            Text(text = "На собственные нужды")
            RadioButton(
                selected = !state,
                onClick = { state = false },
                modifier = Modifier.semantics { contentDescription = "Localized Description" }
            )
            Text(text = "На утилизацию")
        }

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
fun WriteOffProductPrewie() {
    WriteOffProduct(modifier = Modifier.fillMaxSize())
}