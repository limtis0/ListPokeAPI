package com.innowise.listpokeapi.data.models.api

data class PokemonNameUrlList(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonNameUrl>
)