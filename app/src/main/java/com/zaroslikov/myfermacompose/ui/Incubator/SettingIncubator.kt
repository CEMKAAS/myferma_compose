package com.zaroslikov.myfermacompose.ui.Incubator

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zaroslikov.myfermacompose.R
import com.zaroslikov.myfermacompose.ui.TopAppBarIncubator
import com.zaroslikov.myfermacompose.ui.TopAppBarStart
import com.zaroslikov.myfermacompose.ui.add.ChooiseProjectContainer


@Composable
fun Incubator(navigateBack: () -> Unit) {

    val oneIncubatorShowBottomSheet = remember { mutableStateOf(false) }
    val settingShowBottomSheet = remember { mutableStateOf(false) }
    val ovosShowBottomSheet = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBarIncubator(
                title = "Инкубатор",
                true,
                navigateUp = navigateBack,
                showBottom = settingShowBottomSheet
            )
        }) { innerPadding ->

        IncubatorContainer(
            modifier = Modifier.padding(innerPadding),
            oneIncubatorShowBottomSheet = oneIncubatorShowBottomSheet,
            settingShowBottomSheet = settingShowBottomSheet,
            ovosShowBottomSheet = ovosShowBottomSheet
        )
    }
}

@Composable
fun IncubatorContainer(
    modifier: Modifier,
    oneIncubatorShowBottomSheet: MutableState<Boolean>,
    settingShowBottomSheet: MutableState<Boolean>,
    ovosShowBottomSheet: MutableState<Boolean>
) {

    LazyColumn(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        items(31) {
            MyRowIncubatorSettting(
                it,
                showBottom = oneIncubatorShowBottomSheet,
                ovos = true,
                ovosShowBottom = ovosShowBottomSheet
            )
        }
    }

    if (ovosShowBottomSheet.value) {
        OvoscopIncubatorSheet(
            modifier = Modifier.fillMaxSize(),
            showBottom = ovosShowBottomSheet
        )
    }

    if (oneIncubatorShowBottomSheet.value) {
        OneDayIncubatorSheet(
            modifier = Modifier.fillMaxSize(),
            showBottom = oneIncubatorShowBottomSheet
        )
    }

    if (settingShowBottomSheet.value) {
        SettingIncubatorSheet(
            modifier = Modifier.fillMaxSize(),
            showBottom = settingShowBottomSheet
        )
    }
}


@Composable
fun MyRowIncubatorSettting(
    n: Int,
    showBottom: MutableState<Boolean>,
    ovos: Boolean,
    ovosShowBottom: MutableState<Boolean>
) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .clickable {
                showBottom.value = true
            },
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors()
    ) {

//clikable
        Text(
            text = "День ${n+1}",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth(),
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Температура 37,5°C",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(6.dp)
            )
            Text(
                text = "Влажность 60%",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(6.dp)
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Переворачивать 2-3 раза",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(6.dp)
            )
            Text(
                text = "Проветривать 2 раза по 5 минут",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(6.dp)
            )
        }
        if (ovos) {
            TextButton(
                onClick = { ovosShowBottom.value = true },
                modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Овоскопирование",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )
                }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OneDayIncubatorSheet(
    modifier: Modifier,
    showBottom: MutableState<Boolean>,
) {
    //запоминает состояние для BottomShee

    ModalBottomSheet(onDismissRequest = { showBottom.value = false }) {
        var text by rememberSaveable { mutableStateOf("") }
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingIncubatorSheet(
    modifier: Modifier,
    showBottom: MutableState<Boolean>,
) {
    //запоминает состояние для BottomShee

    ModalBottomSheet(onDismissRequest = { showBottom.value = false }) {
        var text by rememberSaveable { mutableStateOf("") }
        Column(
            modifier = modifier.padding(5.dp, 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var text by rememberSaveable { mutableStateOf("") }

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Название инкубатора") },
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    Text("Укажите название инкубатора")
                },
                suffix = { Text(text = "°C") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                //            isError = () TODO
            )
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Количество") },
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    Text("Укажите кол-во яиц")
                },
                suffix = { Text(text = "шт") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_egg_24),
                        contentDescription = "Период"
                    )
                }
//            isError = () TODO
            )
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Уведомление 1") },
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    Text("Укажите время")
                },
                suffix = { TODO() },
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_access_time_24),
                        contentDescription = "Период"
                    )
                }
//            isError = () TODO
            )
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Уведомление 2") },
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    Text("Укажите время")
                },
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_access_time_24),
                        contentDescription = "Период"
                    )
                }
//            isError = () TODO
            )

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Уведомление 3") },
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    Text("Укажите время")
                },
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_access_time_24),
                        contentDescription = "Период"
                    )
                }
//            isError = () TODO
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
                Button(onClick = { }) {
                    Text(text = "Завершить")

                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OvoscopIncubatorSheet(
    modifier: Modifier,
    showBottom: MutableState<Boolean>,
) {
    //запоминает состояние для BottomShee

    ModalBottomSheet(onDismissRequest = { showBottom.value = false }) {
        Column(
            modifier = modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Text(text = "День 1", fontSize = 25.sp)

            Image(
                painter = painterResource(id = R.drawable.quail1),
                contentDescription = null,
                modifier = Modifier
                    .padding(vertical = 25.dp)
                    .fillMaxWidth()
                    .height(250.dp)
            )

            Text(
                text = "Овоскопировать еще рано, на 7 день яйцо должно выглядеть так, если нет, его нужно убрать из инкубатора",
                textAlign = TextAlign.Justify
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun SettingIncubatorPrewie() {
    Incubator(navigateBack = {})
}

@Preview(showBackground = true)
@Composable
fun OneDayIncubatorSheetPrewie() {
    OneDayIncubatorSheet(
        modifier = Modifier.fillMaxSize(),
        showBottom = remember { mutableStateOf(true) })
}

@Preview(showBackground = true)
@Composable
fun SettingIncubatorSheetPrewie() {
    SettingIncubatorSheet(
        modifier = Modifier.fillMaxSize(),
        showBottom = remember { mutableStateOf(true) })
}

@Preview(showBackground = true)
@Composable
fun OvoscopIncubatorSheetPrewie() {
    OvoscopIncubatorSheet(
        modifier = Modifier.fillMaxSize(),
        showBottom = remember { mutableStateOf(true) })
}


//    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
//        Row(
//            modifier = Modifier
//                .height(40.dp)
//                .background(color = Color(red = 238, green = 243, blue = 220))
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = "День",
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth(0.16f)
//                    .padding(6.dp)
//            )
//            Divider(
//                color = Color.DarkGray,
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .width(1.dp)
//            )
//            Text(
//                text = "°C",
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth(0.16f)
//                    .padding(6.dp)
//            )
//            Divider(
//                color = Color.DarkGray,
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .width(1.dp)
//            )
//            Text(
//                text = "%",
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth(0.16f)
//                    .padding(6.dp)
//            )
//            Divider(
//                color = Color.DarkGray,
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .width(1.dp)
//            )
//            Text(
//                text = "Поворот",
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth(0.3f)
//                    .padding(6.dp)
//            )
//            Divider(
//                color = Color.DarkGray,
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .width(1.dp)
//            )
//            Text(
//                text = "Проветривание",
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(6.dp)
//            )
//        }
//        Divider(color = Color.DarkGray, thickness = 1.dp)
//        LazyVerticalGrid(columns = GridCells.Fixed(1)) {
//            items(30) {
//                MyRowIncubatorSettting()
//            }
//        }
//        Divider(color = Color.DarkGray, thickness = 1.dp)
//
//        Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(vertical = 5.dp)) {
//            Text(text = "Запустить")
//
//        }
//    }
//


//@Composable
//fun MyRowIncubatorSettting() {
//    //clikable
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(35.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//
//        Text(
//            text = "1",
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .fillMaxWidth(0.16f)
//                .padding(6.dp)
//        )
//        Divider(
//            color = Color.DarkGray,
//            modifier = Modifier
//                .fillMaxHeight()
//                .width(1.dp)
//        )
//        Text(
//            text = "1",
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .fillMaxWidth(0.16f)
//                .padding(6.dp)
//        )
//        Divider(
//            color = Color.DarkGray,
//            modifier = Modifier
//                .fillMaxHeight()
//                .width(1.dp)
//        )
//        Text(
//            text = "1",
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .fillMaxWidth(0.16f)
//                .padding(6.dp)
//        )
//        Divider(
//            color = Color.DarkGray,
//            modifier = Modifier
//                .fillMaxHeight()
//                .width(1.dp)
//        )
//        Text(
//            text = "1",
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .fillMaxWidth(0.3f)
//                .padding(6.dp)
//        )
//        Divider(
//            color = Color.DarkGray,
//            modifier = Modifier
//                .fillMaxHeight()
//                .width(1.dp)
//        )
//        Text(
//            text = "1",
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(6.dp)
//        )
//
//    }
//    Divider(color = Color.DarkGray, thickness = 1.dp)
//}

//TODO BottomSetting + clikable
