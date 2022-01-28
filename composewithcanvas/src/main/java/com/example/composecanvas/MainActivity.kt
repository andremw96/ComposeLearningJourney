package com.example.composecanvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composecanvas.ui.theme.ComposeCanvasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCanvasTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        InstagramIcon()

                        Spacer(
                            modifier = Modifier
                                .height(2.dp)
                                .width(100.dp)
                                .background(Color.Black)
                        )

                        FacebookIcon()

                        Spacer(
                            modifier = Modifier
                                .height(2.dp)
                                .width(100.dp)
                                .background(Color.Black)
                        )

                        MessengerIcon()

                        Spacer(
                            modifier = Modifier
                                .height(2.dp)
                                .width(100.dp)
                                .background(Color.Black)
                        )

                        GooglePhotosIcon()

                        Spacer(
                            modifier = Modifier
                                .height(2.dp)
                                .width(100.dp)
                                .background(Color.Black)
                        )

                        WeatherIcon()
                    }
                }
            }
        }
    }
}

