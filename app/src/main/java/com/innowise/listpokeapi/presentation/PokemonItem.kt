package com.innowise.listpokeapi.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.innowise.listpokeapi.data.local.PokemonEntity
import com.innowise.listpokeapi.data.local.PokemonType
import com.innowise.listpokeapi.presentation.theme.ListPokeAPITheme

@Composable
fun PokemonItem(
    pokemon: PokemonEntity,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .size(150.dp),
        elevation = 4.dp
    ) {
        Column {
            AsyncImage(
                model = pokemon.sprite,
                contentDescription = pokemon.name,
                modifier = Modifier
                    .fillMaxHeight(0.75f)
                    .align(Alignment.CenterHorizontally)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = pokemon.name,
                    style = TextStyle(fontWeight = FontWeight.Medium),
                    modifier = Modifier,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Preview
@Composable
fun PokemonItemPreview() {
    ListPokeAPITheme {
        PokemonItem(pokemon = PokemonEntity(
            id = 1,
            name = "Bulbasaur",
            sprite = "NA",
            types = listOf(PokemonType.GRASS, PokemonType.POISON),
            heightCM = 70.0,
            weightKG = 6.9
        ))
    }
}
