package com.zaroslikov.myfermacompose.ui.Incubator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zaroslikov.myfermacompose.R

@Composable
fun FotoIncybator(modifier: Modifier){

    Column(modifier = modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {

        Text(text = "День 1", fontSize = 25.sp)

        Image(painter = painterResource(id = R.drawable.quail1), contentDescription = null, modifier = Modifier.padding(vertical = 25.dp).fillMaxWidth().height(250.dp))

        Text(text = "Овоскопировать еще рано, на 7 день яйцо должно выглядеть так, если нет, его нужно убрать из инкубатора", textAlign = TextAlign.Justify)

    }
// TODO Подкорректировать если будет не сходится
}



@Preview(showBackground = true)
@Composable
fun FotoIncubatorPrewie(){
    FotoIncybator(modifier = Modifier.fillMaxSize())
}