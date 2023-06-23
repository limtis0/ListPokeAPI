package com.innowise.listpokeapi.data.api

data class PokemonDTO(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val sprites: SpritesObject,
    val types: List<TypesObject>
)

data class SpritesObject (
    val front_default: String
)

data class TypesObject (
    val type: Type
)

data class Type(
    val name: String
)