package com.innowise.listpokeapi.domain.api;

import com.innowise.listpokeapi.data.local.PokemonEntity
import com.innowise.listpokeapi.data.mappers.toEntity
import com.innowise.listpokeapi.domain.di.DaggerApplicationComponent
import javax.inject.Inject;

class SimplePokeAPI {
    @Inject
    lateinit var pokeAPI: PokeAPI

    init {
        val diAppComponent = DaggerApplicationComponent.create()
        diAppComponent.inject(this)
    }

    suspend fun getPokemonsPage(pageIndex: Int, limit: Int = 20) : List<PokemonEntity> {
        val pokemonsToGet = pokeAPI.getPokemons(limit, pageIndex * limit).results
        val pokemonIDs = pokemonsToGet.map {
            val split = it.url.split("/")
            split[split.size - 2].toInt()
        }

        return pokemonIDs.map { pokeAPI.getSinglePokemon(it).toEntity() }
    }
}
