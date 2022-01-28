package com.example.composelearningjourney

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composelearningjourney.ui.theme.ComposeLearningJourneyTheme
import com.example.android.codelab.animation.MainActivity as AnimationActivity
import com.plcoding.meditationuiyoutube.MainActivity as MeditationActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearningJourneyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        ButtonGoTo("Meditation UI with Compose") {
                            startActivity(Intent(
                                this@MainActivity, MeditationActivity::class.java
                            ))
                        }
                        
                        Spacer(modifier = Modifier.padding(8.dp))

                        ButtonGoTo("Animation With Compose") {
                            startActivity(Intent(
                                this@MainActivity, AnimationActivity::class.java
                            ))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ButtonGoTo(name: String, onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        Modifier
            .fillMaxWidth()
    ) {
        Text(text = "Go To Module $name", textAlign = TextAlign.Center)
    }
}
