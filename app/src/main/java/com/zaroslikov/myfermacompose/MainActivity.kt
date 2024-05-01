package com.zaroslikov.myfermacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.zaroslikov.myfermacompose.ui.MyAppFerma
import com.zaroslikov.myfermacompose.ui.theme.MyFermaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFermaComposeTheme {
                MyAppFerma()
            }
        }
    }
}

