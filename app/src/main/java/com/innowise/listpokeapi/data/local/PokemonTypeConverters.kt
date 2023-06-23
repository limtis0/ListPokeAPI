package com.innowise.listpokeapi.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.reflect.typeOf

class PokemonTypeConverters {
    @TypeConverter
    fun pokemonTypesToString(pokemonTypes: List<PokemonType>) : String {
        return Gson().toJson(pokemonTypes)
    }

    @TypeConverter
    fun stringToPokemonTypes(pokemonTypes: String) : List<PokemonType> {
        val listType = object : TypeToken<List<PokemonType>>() {}.type
        return Gson().fromJson(pokemonTypes, listType)
    }
}