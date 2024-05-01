package com.zaroslikov.myfermacompose.ui.Incubator


import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun OneDayIncubator(modifier: Modifier) {
    Column(
        modifier = modifier.padding(5.dp, 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text by rememberSaveable { mutableStateOf("") }

        Text(
            text = "День 1",
            fontSize = 25.sp, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Температура") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите температуру")
            },
            suffix = { Text(text = "°C") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            //            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Влажность") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите влажность")
            },
            suffix = { Text(text = "%") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Переворот") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите кол-во переворачиваний")
            },
            suffix = { TODO() },
//            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Проветривание") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите кол-во проветриваний")
            },
//            isError = () TODO
        )

        Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(vertical = 10.dp)) {
            Text(text = "Обновить")
            //TODO Изображение
        }
    }
}


@Preview(showBackground = true)
@Composable
fun OneDayIncubatorPrewie() {
    OneDayIncubator(modifier = Modifier.fillMaxSize())
}