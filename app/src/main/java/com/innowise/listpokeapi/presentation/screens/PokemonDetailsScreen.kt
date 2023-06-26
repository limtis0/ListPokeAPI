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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.innowise.listpokeapi.data.local.PokemonEntity
import com.innowise.listpokeapi.data.local.PokemonType
import com.innowise.listpokeapi.presentation.common.SetTemporarySystemBarsColor
import com.innowise.listpokeapi.presentation.common.pokemonTypeToColor
import com.innowise.listpokeapi.presentation.elements.PokemonTypeItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PokemonDetailsScreen(navigator: DestinationsNavigator, pokemon: PokemonEntity) {
    val uiColor = pokemonTypeToColor.getOrDefault(pokemon.types[0], Color.LightGray)

    SetTemporarySystemBarsColor(uiColor, MaterialTheme.colors.primary)

    Surface {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxHeight(0.4f)
                    .fillMaxWidth()
                    .background(
                        color = uiColor,
                        shape = RectangleShape
                    )
            ) {
                AsyncImage(
                    model = pokemon.sprite,
                    contentDescription = pokemon.name,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .size(128.dp)
                )
            }
            Spacer(modifier = Modifier.size(16.dp))

            // Name and ID
            Row {
                Text(
                    text = pokemon.name,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 34.sp,
                        letterSpacing = 0.25.sp
                    )
                )
                Text(
                    text = "#${"%04d".format(pokemon.id)}",
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .padding(start = 8.dp, bottom = 4.8.dp)
                )
            }
            Spacer(modifier = Modifier.size(8.dp))

            // Types
            Row {
                for (pokemonType: PokemonType in pokemon.types) {
                    PokemonTypeItem(pokemonType = pokemonType)
                }
            }
            Spacer(modifier = Modifier.size(8.dp))

            // Weight
            Text(text = "Weight: ${pokemon.weightKG} kg", style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.size(8.dp))

            // Height
            Text(text = "Height: ${pokemon.heightCM} cm", style = MaterialTheme.typography.body1)
            Spacer(modifier = Modifier.size(32.dp))

            // Commentary
            Text(
                text = "// There could be much more info, but it is alright...",
                style = MaterialTheme.typography.body2
            )
            
            Spacer(modifier = Modifier.weight(1f))
            Button(
                modifier = Modifier
                    .padding(bottom = 64.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = uiColor,
                    contentColor = Color.White
                ),
                onClick = { navigator.navigateUp() }
            ) {
                Text(
                    text = "Back to Pokemon List",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}
