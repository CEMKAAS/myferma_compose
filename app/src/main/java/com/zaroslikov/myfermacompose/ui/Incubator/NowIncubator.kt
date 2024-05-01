package com.zaroslikov.myfermacompose.ui.Incubator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun NowIncubator(modifier: Modifier) {

    val modifierRow = Modifier
        .fillMaxWidth()
        .padding(vertical = 2.5.dp, horizontal = 5.dp)

    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Идет 1 день", fontSize = 25.sp, modifier = Modifier.padding(5.dp))
        Text(text = "Температура должна быть ${"37.5°C"}", modifier = modifierRow)
        Text(text = "Влажность должна быть ${"60 %"}", modifier = modifierRow)
        Text(text = "Переворачивать нужно ${"2-3 раза"}", modifier = modifierRow)
        Text(text = "Проветривать нужно ${"2 раза по 5 минут"}", modifier = modifierRow)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Изменить")
                //TODO Изображение
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Фото")
                //TODO Изображение
            }
        }

        Text(text = "Завтра", fontSize = 25.sp, modifier = Modifier.padding(5.dp))
        Text(text = "Температура должна быть ${"37.5°C"}", modifier = modifierRow)
        Text(text = "Влажность должна быть ${"60 %"}", modifier = modifierRow)
        Text(text = "Переворачивать нужно ${"2-3 раза"}", modifier = modifierRow)
        Text(text = "Проветривать нужно ${"2 раза по 5 минут"}", modifier = modifierRow)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Настройка")
                //TODO Изображение
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Завершить")
                //TODO Изображение
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun NowIncubatorPrewie() {
    NowIncubator(modifier = Modifier.fillMaxSize())
}