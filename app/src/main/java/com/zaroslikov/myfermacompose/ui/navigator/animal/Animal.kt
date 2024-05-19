package com.zaroslikov.myfermacompose.ui.navigator.animal

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zaroslikov.myfermacompose.R
import com.zaroslikov.myfermacompose.ui.DrawerSheet
import com.zaroslikov.myfermacompose.ui.FilterProductSheet
import com.zaroslikov.myfermacompose.ui.TopAppBarFerma
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Animal(
    scope: CoroutineScope,
    drawerState: DrawerState,
    navController: NavController,
    gesturesEnabled: MutableState<Boolean>
) {

//запоминает состояние для BottomSheet
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true

    )
    val showBottomSheet = remember { mutableStateOf(false) }
    val showBottomSheetFilter = remember { mutableStateOf(false) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerSheet(scope = scope, navController = navController, drawerState = drawerState, 7)
        },
    ) {
        Scaffold(
            topBar = {
                TopAppBarFerma(
                    title = "Мои Животные",
                    scope = scope,
                    drawerState = drawerState,
                    showBottomFilter = showBottomSheetFilter,
                    filterSheet = true
                )
            },
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    onClick = {
                        showBottomSheet.value = true
                    },
                    icon = { Icon(Icons.Filled.Add, "Добавить") },
                    text = { Text(text = "Добавить") },
                )
            }
        ) { innerPadding ->
            AnimalContainer(
                modifier = Modifier.padding(innerPadding),
                showBottom = showBottomSheet,
                showBottomFilter = showBottomSheetFilter,
                navController = navController,
                sheetState = sheetState
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalContainer(
    modifier: Modifier,
    showBottom: MutableState<Boolean>,
    showBottomFilter: MutableState<Boolean>,
    navController: NavController,
    sheetState: SheetState
) {

    LazyVerticalGrid(columns = GridCells.Fixed(1), modifier = modifier) {
        items(30) {
            AnimalCardScroll(navController = navController)
        }
    }
    if (showBottomFilter.value) {
        FilterProductSheet(
            showBottom = showBottomFilter
        )
    }

    if (showBottom.value) {
        AddAnimalSheet(
            showBottom = showBottom,
            sheetState = sheetState
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAnimalSheet(
    showBottom: MutableState<Boolean>,
    sheetState: SheetState
) {
    //запоминает состояние для BottomShee

//    ModalBottomSheet(
//        onDismissRequest = { showBottom.value = false },
//        sheetState = sheetState,
//    ) {
    var text by rememberSaveable { mutableStateOf("") }
    Column(modifier = Modifier.padding(5.dp, 5.dp)) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Имя") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите имя или группу животных")
            }
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Тип") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите или выберите тип животного")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Пол") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Выберите пол, если вы заносите стаю, то выберите неизвестно")
            },
            suffix = { Text(text = "Шт.") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Вес") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите вес животного")
            },
            suffix = { Text(text = "кг.") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Количество") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите кол-во животных, если у Вас стая")
            },
            suffix = { Text(text = "Шт.") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Дата рождения") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите дату рождения или дату покупки")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            trailingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.baseline_calendar_month_24),
                    contentDescription = "Период"
                )
            }
//            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Прививка") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите дату, когда была сделана прививка")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            trailingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.baseline_calendar_month_24),
                    contentDescription = "Период"
                )
            }
//            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Примечание") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите примечания")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

//            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Картинка") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Загрузите картинку")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

//            isError = () TODO
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Добавить")
                //TODO Изображение
            }
        }
    }
}


@Composable
fun AnimalCardScroll(navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                navController.navigate("AnimalCard")
            },
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.moroska),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(125.dp)
                    .padding(10.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.White, shape = CircleShape)
            )


            Column {
                Text(
                    text = "Морошка",
                    modifier = Modifier
                        .padding(6.dp),
                    fontWeight = FontWeight.SemiBold,
                )

                Text(
                    text = "Дата: 02.05.2024",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(6.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AnimalCardPrewie() {
    AnimalCardScroll(navController = rememberNavController())
}


//@Preview(showBackground = true)
//@Composable
//fun AnimalPrewie() {
//    Animal(
//        scope = rememberCoroutineScope(),
//        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
//        navController = rememberNavController()
//    )
//}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AddProductSheetPrewie() {
    AddAnimalSheet(
        showBottom = remember { mutableStateOf(true) },
        sheetState = rememberModalBottomSheetState()
    )
}