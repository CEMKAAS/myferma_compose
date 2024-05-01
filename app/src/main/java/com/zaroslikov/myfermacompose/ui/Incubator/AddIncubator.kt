package com.zaroslikov.myfermacompose.ui.Incubator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zaroslikov.myfermacompose.R

@Composable
fun AddIncubator(modifier: Modifier) {
    var text by rememberSaveable { mutableStateOf("") }
    val checkedStateAiring = remember { mutableStateOf(false) }
    val checkedStateOver = remember { mutableStateOf(false) }
    Column(modifier = modifier.padding(5.dp, 5.dp)) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Инкубатор №1") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите название инкубатора")
            }
            //            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Тип птицы") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Выберите тип птицы")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Дата") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите дату")
            },
            suffix = { TODO() },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Количество") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите кол-во яий, которых заложили в инкубатор")
            },
            suffix = { Text(text = "Шт.") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Уведомление 1") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите время уведомления")
            },
            suffix = {  TODO() },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Уведомления 2") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите время уведомления")
            },
            suffix = {  TODO() },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Уведомления 3") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите время уведомления")
            },
            suffix = {  TODO() },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )


        Row(Modifier.selectableGroup().fillMaxWidth()
            .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkedStateAiring.value,
                onCheckedChange = { checkedStateAiring.value = it }
            )
            Text(text = "Авто охлаждение")
            Checkbox(
                checked = checkedStateOver.value,
                onCheckedChange = { checkedStateOver.value = it }
            )
            Text(text = "Авто переворот")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Далее")
                //TODO Изображение
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AddIncubatorPrewie() {
    AddIncubator(modifier = Modifier.fillMaxSize())
}