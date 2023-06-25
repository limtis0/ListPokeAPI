package com.innowise.listpokeapi.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.innowise.listpokeapi.data.local.PokemonEntity
import com.innowise.listpokeapi.data.local.PokemonType
import com.innowise.listpokeapi.presentation.PokemonTypeItem
import com.innowise.listpokeapi.presentation.pokemonTypeToColor
import com.innowise.listpokeapi.presentation.theme.ListPokeAPITheme
import com.innowise.listpokeapi.presentation.theme.typography

@Composable
fun PokemonDetailsScreen(pokemon: PokemonEntity) {
    val bgColor = pokemonTypeToColor.getOrDefault(pokemon.types[0], Color.LightGray)

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth()
                .background(
                    color = bgColor,
                    shape = RectangleShape
                )
        ) {
            AsyncImage(
                model = pokemon.sprite,
                contentDescription = pokemon.name,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxHeight()
            )
        }
        Spacer(modifier = Modifier.size(16.dp))

        // Name and ID
        Text(
            text = "${pokemon.name} #${"%04d".format(pokemon.id)}",
            style = typography.h4
        )
        Spacer(modifier = Modifier.size(8.dp))

        // Types
        Row {
            for (pokemonType: PokemonType in pokemon.types) {
                PokemonTypeItem(pokemonType = pokemonType)
            }
        }
        Spacer(modifier = Modifier.size(8.dp))

        // Weight
        Text(text = "Weight: ${pokemon.weightKG} kg", style = typography.body1)
        Spacer(modifier = Modifier.size(8.dp))

        // Height
        Text(text = "Height: ${pokemon.heightCM} cm", style = typography.body1)
        Spacer(modifier = Modifier.size(32.dp))

        // Commentary
        Text(
            text = "// There could be much more info, but it is alright...",
            style = typography.body2
        )
    }
}

@Preview
@Composable
fun PokemonDetailsPreview() {
    ListPokeAPITheme {
        PokemonDetailsScreen(pokemon = PokemonEntity(
            id = 1,
            name = "Bulbasaur",
            sprite = "NA",
            types = listOf(PokemonType.GRASS, PokemonType.POISON),
            heightCM = 70.0,
            weightKG = 6.9
        ))
    }
}
