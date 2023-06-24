package com.innowise.listpokeapi.presentation.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

private val darkColorPalette = darkColors(
    primary = primaryRed,
    primaryVariant = primaryVariantRed,
    secondary = secondaryRed
)

private val lightColorPalette = lightColors(
    primary = primaryRed,
    primaryVariant = primaryVariantRed,
    secondary = secondaryRed
)

@Composable
fun ListPokeAPITheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Decide on color scheme
    val colors = if (darkTheme) {
        darkColorPalette
    } else {
        lightColorPalette
    }

    // Set status bar color
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.primary.toArgb()
            window.navigationBarColor = colors.primary.toArgb()
        }
    }

    // Return the theme
    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
