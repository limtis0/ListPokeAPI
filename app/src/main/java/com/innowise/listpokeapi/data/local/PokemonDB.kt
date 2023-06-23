package com.innowise.listpokeapi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [PokemonEntity::class], version = 1, exportSchema = false)
@TypeConverters(PokemonTypeConverters::class)
abstract class PokemonDB : RoomDatabase() {
    abstract val dao: PokemonDao
}