package com.innowise.listpokeapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.innowise.listpokeapi.presentation.screens.NavGraphs
import com.innowise.listpokeapi.presentation.theme.ListPokeAPITheme
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ListPokeAPITheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
