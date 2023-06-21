package com.innowise.listpokeapi.data.models.api

data class Pokemon(
    val sprite: String,
    val types: List<PokemonType>,
    val weightKG: Double,
    val heightCM: Double,
)
