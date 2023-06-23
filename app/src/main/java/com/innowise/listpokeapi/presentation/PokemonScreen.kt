package com.innowise.listpokeapi.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Box
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
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.innowise.listpokeapi.data.local.PokemonEntity

@Composable
fun PokemonScreen(
    pokemons: LazyPagingItems<PokemonEntity>
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = pokemons.loadState) {
        if (pokemons.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (pokemons.loadState.refresh as LoadState.Error).error.message,
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
                columns = GridCells.Adaptive(minSize = 100.dp)  // TODO: Redact if needed
            ) {
                items(pokemons.itemCount) { index ->
                    val pokemon = pokemons[index]
                    if (pokemon != null) {
                        PokemonItem(
                            pokemon = pokemon,
                            modifier = Modifier
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