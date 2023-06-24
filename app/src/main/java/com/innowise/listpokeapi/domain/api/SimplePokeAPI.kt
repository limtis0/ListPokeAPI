package com.innowise.listpokeapi.domain.api

import com.innowise.listpokeapi.data.local.PokemonEntity
import com.innowise.listpokeapi.data.mappers.toEntity

class SimplePokeAPI(private val pokeAPI: PokeAPI) {
    suspend fun getPokemonsPage(pageIndex: Int, limit: Int = 20) : List<PokemonEntity> {
        val pokemonsToGet = pokeAPI.getPokemons(limit, pageIndex * limit).results
        val pokemonIDs = pokemonsToGet.map {
            val split = it.url.split("/")
            split[split.size - 2].toInt()
        }

        return pokemonIDs.map { pokeAPI.getSinglePokemon(it).toEntity() }
    }
}
