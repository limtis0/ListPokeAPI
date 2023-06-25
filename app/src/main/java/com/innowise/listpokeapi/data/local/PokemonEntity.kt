package com.innowise.listpokeapi.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val sprite: String,
    val types: List<PokemonType>,
    val weightKG: Double,
    val heightCM: Double,
)
