package com.innowise.listpokeapi.data.mappers

import com.innowise.listpokeapi.data.api.PokemonDTO
import com.innowise.listpokeapi.data.local.PokemonEntity
import com.innowise.listpokeapi.data.local.PokemonType

fun PokemonDTO.toEntity() : PokemonEntity {
    return PokemonEntity(
        id,
        name,
        sprites.front_default,
        types.map { PokemonType.valueOf(it.type.name) },
        weight.toDouble() / 10,
        height.toDouble() * 10,
    )
}
