package com.zaroslikov.myfermacompose.ui.Incubator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SettingIncubator(modifier: Modifier) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier
                .height(40.dp)
                .background(color = Color(red = 238, green = 243, blue = 220))
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "День",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.16f)
                    .padding(6.dp)
            )
            Divider(
                color = Color.DarkGray,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Text(
                text = "°C",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.16f)
                    .padding(6.dp)
            )
            Divider(
                color = Color.DarkGray,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Text(
                text = "%",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.16f)
                    .padding(6.dp)
            )
            Divider(
                color = Color.DarkGray,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Text(
                text = "Поворот",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .padding(6.dp)
            )
            Divider(
                color = Color.DarkGray,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Text(
                text = "Проветривание",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
            )
        }
        Divider(color = Color.DarkGray, thickness = 1.dp)
        LazyVerticalGrid(columns = GridCells.Fixed(1)) {
            items(30) {
                MyRowIncubatorSettting()
            }
        }
        Divider(color = Color.DarkGray, thickness = 1.dp)

        Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(vertical = 5.dp)) {
            Text(text = "Запустить")

        }
    }


}

@Composable
fun MyRowIncubatorSettting() {
    //clikable
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(35.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "1",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(0.16f)
                .padding(6.dp)
        )
        Divider(
            color = Color.DarkGray,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
        )
        Text(
            text = "1",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(0.16f)
                .padding(6.dp)
        )
        Divider(
            color = Color.DarkGray,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
        )
        Text(
            text = "1",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(0.16f)
                .padding(6.dp)
        )
        Divider(
            color = Color.DarkGray,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
        )
        Text(
            text = "1",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .padding(6.dp)
        )
        Divider(
            color = Color.DarkGray,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
        )
        Text(
            text = "1",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        )

    }
    Divider(color = Color.DarkGray, thickness = 1.dp)
}

//TODO BottomSetting + clikable



@Preview(showBackground = true)
@Composable
fun SettingIncubatorPrewie() {
    SettingIncubator(modifier = Modifier.fillMaxSize())
}


