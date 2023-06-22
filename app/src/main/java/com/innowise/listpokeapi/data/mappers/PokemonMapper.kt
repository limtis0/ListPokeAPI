package com.innowise.listpokeapi.data.mappers

import com.innowise.listpokeapi.data.local.PokemonType
import com.innowise.listpokeapi.data.api.PokemonDTO
import com.innowise.listpokeapi.data.local.PokemonEntity

fun PokemonDTO.toEntity() : PokemonEntity {
    return PokemonEntity(
        name,
        sprites.front_default,
        types.map { PokemonType.valueOf(it.type.name) },
        weight.toDouble() / 10,
        height.toDouble() * 10,
    )
}
