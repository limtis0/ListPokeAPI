package com.innowise.listpokeapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.paging.Pager
import androidx.paging.compose.collectAsLazyPagingItems
import com.innowise.listpokeapi.data.local.PokemonEntity
import com.innowise.listpokeapi.presentation.screens.PokemonScreen
import com.innowise.listpokeapi.presentation.PokemonViewModel
import com.innowise.listpokeapi.presentation.theme.ListPokeAPITheme
import javax.inject.Inject


class MainActivity : ComponentActivity() {
    @Inject
    lateinit var pokemonPager: Pager<Int, PokemonEntity>

    init {
        ListPokeAPIApplication.appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ListPokeAPITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel = PokemonViewModel(pokemonPager)
                    PokemonScreen(
                        pokemons = viewModel.pokemonPagingFlow.collectAsLazyPagingItems()
                    )
                }
            }
        }
    }
}