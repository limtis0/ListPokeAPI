package com.innowise.listpokeapi.infrastructure.api;

import com.innowise.listpokeapi.data.local.PokemonEntity
import com.innowise.listpokeapi.data.mappers.toEntity
import com.innowise.listpokeapi.infrastructure.di.DaggerApplicationComponent
import javax.inject.Inject;

class SimplePokeAPI {
    @Inject
    lateinit var pokeAPI: PokeAPI

    init {
        val diAppComponent = DaggerApplicationComponent.create()
        diAppComponent.inject(this)
    }

    suspend fun getPokemonsPage(pageIndex: Int, pageLimit: Int = 20) : List<PokemonEntity> {
        val pokemonsToGet = pokeAPI.getPokemons(pageLimit, pageIndex * pageLimit).results
        val pokemonIDs = pokemonsToGet.map { it.url.split("/").last().toInt() }

        return pokemonIDs.map { pokeAPI.getSinglePokemon(it).toEntity() }
    }
}
