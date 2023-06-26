package com.innowise.listpokeapi.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.accompanist.drawablepainter.DrawablePainter
import com.innowise.listpokeapi.presentation.common.HideSystemBarsTemporary
import com.innowise.listpokeapi.presentation.screens.destinations.PokemonListScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay

@RootNavGraph(start = true)
@Destination
@Composable
fun SplashScreen(
    navigator: DestinationsNavigator
) {
    HideSystemBarsTemporary(hideStatusBar = false)

    // Delay for 2 seconds before navigating to the main screen
    LaunchedEffect(Unit) {
        delay(2000)
        navigator.navigate(PokemonListScreenDestination)
    }

    val packageManager = LocalContext.current.packageManager
    val appIcon = packageManager.getApplicationIcon(LocalContext.current.packageName)

    // Display the app icon as an image
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = DrawablePainter(appIcon),
                contentDescription = "App Icon",
                modifier = Modifier.size(128.dp)
            )
        }
    }
}
