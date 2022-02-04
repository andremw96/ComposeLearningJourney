package com.example.composetablayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.composetablayout.ui.theme.ComposeTabLayoutTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTabLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TabLayoutScreen()
                }
            }
        }
    }
}

private val tabItems = listOf(
    TabItem.Home,
    TabItem.Settings,
    TabItem.Contacts
)

@ExperimentalPagerApi
@Composable
fun TabLayoutScreen() {
    val pagerState = rememberPagerState()

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        val coroutineScope = rememberCoroutineScope()
        IconWithTextTabLayout(
            tabItems = tabItems,
            selectedIndex = pagerState.currentPage,
            onPageSelected = { tabItem ->  
                coroutineScope.launch {
                    pagerState.animateScrollToPage(tabItem.index)
                }
            }
        )
    }) {
        TabPage(pagerState = pagerState, tabItems = tabItems)
    }
}
