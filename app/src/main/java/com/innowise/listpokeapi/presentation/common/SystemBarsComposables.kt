package com.innowise.listpokeapi.presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SetTemporarySystemBarsColor(temporaryColor: Color, originalColor: Color) {
    val systemUiController = rememberSystemUiController()

    DisposableEffect(key1 = true){
        systemUiController.setSystemBarsColor(temporaryColor)

        onDispose {
            systemUiController.setSystemBarsColor(originalColor) // Status bar
        }
    }
}

@Composable
fun HideSystemBarsTemporary(hideStatusBar: Boolean = true, hideNavBar: Boolean = true)
{
    val systemUiController = rememberSystemUiController()

    DisposableEffect(key1 = true){
        systemUiController.isStatusBarVisible = !hideStatusBar
        systemUiController.isNavigationBarVisible = !hideNavBar

        onDispose {
            systemUiController.isSystemBarsVisible = true
        }
    }
}
