package com.example.composehourglass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composehourglass.ui.theme.ComposeHourglassTheme
import com.example.composehourglass.ui.theme.Hourglass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeHourglassTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            Text(
                                text = "Hourglass Animation",
                                color = MaterialTheme.colors.onBackground,
                                style = MaterialTheme.typography.h5,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    ) {
                        Hourglass()
                    }
                }
            }
        }
    }
}
