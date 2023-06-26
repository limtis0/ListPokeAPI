package com.innowise.listpokeapi.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.innowise.listpokeapi.presentation.elements.PokemonItem
import com.innowise.listpokeapi.presentation.viewmodels.PokemonListViewModel
import com.innowise.listpokeapi.presentation.screens.destinations.PokemonDetailsScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PokemonListScreen(
    navigator: DestinationsNavigator
) {
    val viewModel: PokemonListViewModel = viewModel()
    val pokemons = viewModel.pokemonPagingFlow.collectAsLazyPagingItems()

    val context = LocalContext.current
    LaunchedEffect(key1 = pokemons.loadState) {
        if (pokemons.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: ${(pokemons.loadState.refresh as LoadState.Error).error.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (pokemons.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(pokemons.itemCount) { index ->
                    val pokemon = pokemons[index]
                    if (pokemon != null) {
                        PokemonItem(
                            pokemon = pokemon,
                            modifier = Modifier
                                .clickable {
                                    navigator.navigate(
                                        PokemonDetailsScreenDestination(pokemon = pokemon)
                                    )
                                }
                        )
                    }
                }

                item {
                    if (pokemons.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}
