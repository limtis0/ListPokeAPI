package com.innowise.listpokeapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.innowise.listpokeapi.presentation.screens.PokemonListScreen
import com.innowise.listpokeapi.presentation.theme.ListPokeAPITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ListPokeAPITheme {
                PokemonListScreen()
            }
        }
    }
}
