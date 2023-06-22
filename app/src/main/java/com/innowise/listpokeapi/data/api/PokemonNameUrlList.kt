package com.innowise.listpokeapi.data.api

import com.innowise.listpokeapi.data.api.PokemonNameUrl

data class PokemonNameUrlList(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonNameUrl>
)