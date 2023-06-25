package com.innowise.listpokeapi.presentation.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.innowise.listpokeapi.data.local.PokemonType
import com.innowise.listpokeapi.presentation.common.pokemonTypeToColor
import com.innowise.listpokeapi.presentation.theme.ListPokeAPITheme


@Composable
fun PokemonTypeItem(pokemonType: PokemonType) {
    val backgroundColor = pokemonTypeToColor.getOrDefault(pokemonType, Color.LightGray)

    Text(
        text = pokemonType.name,
        style = TextStyle(
            color = Color.White,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.4.sp
        ),
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 12.dp, vertical = 6.dp)
    )
}

@Preview
@Composable
fun PokemonTypeItemPreview() {
    ListPokeAPITheme {
        PokemonTypeItem(PokemonType.ELECTRIC)
    }
}
