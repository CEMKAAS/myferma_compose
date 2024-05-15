package com.zaroslikov.myfermacompose.ui.navigator.animal

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zaroslikov.myfermacompose.R
import com.zaroslikov.myfermacompose.ui.FilterProductSheet
import com.zaroslikov.myfermacompose.ui.TopAppBarStart
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalCard() {


//запоминает состояние для BottomSheet
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val showBottomSheet = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBarStart(title = "Мои Животные", canNavigateBack = false)
        },
    ) { innerPadding ->
        AnimalCardContainer(
            modifier = Modifier.padding(innerPadding)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalCardContainer(
    modifier: Modifier,
) {
    Column(modifier = modifier) {

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
                    text = "Тип: Коза",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(6.dp)
                )

                Text(
                    text = "Пол: Женский",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(6.dp)
                )


            }
        }
        Text(
            text = "Вес: 36 кг.",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(6.dp)
        )
        Text(
            text = "Количество: 1 ",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(6.dp)
        )
        Text(
            text = "Дата рождения: 02.05.2024",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(6.dp)
        )
        Text(
            text = "Дата последней прививки: 02.05.2024",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(6.dp)
        )
        Text(
            text = "Примечание: Коза очень большая и много есть дает 1000  литров молока, не жената, но любит торика, 6 детей и 16 внуков(возможно больше)",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(6.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AnimalCardXPrewie() {
    AnimalCard(
    )
}