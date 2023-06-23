package com.innowise.listpokeapi.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val darkColorPalette = darkColors(
    primary = primaryRedDark,
    primaryVariant = primaryVariantRedDark,
    secondary = secondaryRedDark
)

private val lightColorPalette = lightColors(
    primary = primaryRedWhite,
    primaryVariant = primaryVariantRedWhite,
    secondary = secondaryRedWhite
)

@Composable
fun ListPokeAPITheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorPalette
    } else {
        lightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
