package com.innowise.listpokeapi.data.models

data class PokemonNameUrlList(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonNameUrl>
)