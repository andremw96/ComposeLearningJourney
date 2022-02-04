package com.example.composetablayout

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

sealed class TabItem(
    val index: Int,
    val icon: ImageVector,
    val title: String,
    val screenToLoad: @Composable () -> Unit
) {
    object Home : TabItem(0, Icons.Default.Home, "Home", {
        HomeScreen()
    })

    object Settings : TabItem(1, Icons.Default.Settings, "Settings", {
        SettingScreen()
    })

    object Contacts : TabItem(2, Icons.Default.Call, "Contacts", {
        ContactScreen()
    })
}

