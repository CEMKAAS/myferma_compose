package com.zaroslikov.myfermacompose.ui.add

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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zaroslikov.myfermacompose.ui.TopAppBarStart


@Composable
fun AddProject(navController: NavController, navigateBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBarStart(title = "Мое Хозяйство", true, navigateUp = navigateBack )
        },
    ) { innerPadding ->
        AddProjectContainer(modifier = Modifier.padding(innerPadding), navController)
    }
}

@Composable
fun AddProjectContainer(modifier: Modifier, navController: NavController) {
    var text by rememberSaveable { mutableStateOf("") }
    Column(modifier = modifier.padding(5.dp, 5.dp)) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Птицеводство") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите название проекта")
            }
            //            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("10 000") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Укажите стартовый капитал")
            },
            suffix = { Text(text = "₽") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Птицеводство") },
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                Text("Выберите картинку")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            isError = () TODO
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { navController.navigate("Start") }) {
                Text(text = "Начать")
                //TODO Изображение
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AddProjectPrewie() {
    AddProjectContainer(modifier = Modifier.fillMaxSize(), navController = rememberNavController())
}