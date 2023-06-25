package com.innowise.listpokeapi.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
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
    val bgColor = pokemonTypeToColor.getOrDefault(pokemon.types[0], Color.LightGray)

    Card(
        modifier = modifier
            .aspectRatio(1f),
        elevation = 4.dp
    ) {
        Column {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxHeight(0.75f)
                    .fillMaxWidth()
                    .background(
                        color = bgColor,
                        shape = RectangleShape
                    )
            ) {
                AsyncImage(
                    model = pokemon.sprite,
                    contentDescription = pokemon.name,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxHeight()
                )
            }
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
