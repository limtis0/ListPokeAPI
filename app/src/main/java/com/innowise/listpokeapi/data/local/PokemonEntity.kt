package com.innowise.listpokeapi.data.local

data class PokemonEntity(
    val name: String,
    val sprite: String,
    val types: List<PokemonType>,
    val weightKG: Double,
    val heightCM: Double,
)

