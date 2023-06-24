package com.innowise.listpokeapi.domain.api.tests

import com.innowise.listpokeapi.data.api.PokemonNameUrlList
import com.innowise.listpokeapi.data.api.PokemonDTO
import com.innowise.listpokeapi.domain.api.PokeAPI
import com.innowise.listpokeapi.domain.di.DaggerApplicationComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import javax.inject.Inject

// Testing whether API calls are working as intended
class TestAPICalls {
    @Inject
    lateinit var pokeAPI: PokeAPI

    @Before
    fun setup() {
        val diAppComponent = DaggerApplicationComponent.builder()
            .pokemonDBModule(Mockito.mock())
            .build()
        diAppComponent.inject(this)
    }

    @Test
    fun testGetPokemons() {
        // Act
        val pokemons: PokemonNameUrlList
        runBlocking(Dispatchers.IO) {
            pokemons = pokeAPI.getPokemons(20, 0)
        }

        // Assert
        assertNotNull(pokemons)
        assertEquals(20, pokemons.results.size)
    }

    @Test
    fun testGetSinglePokemon() {
        // Act
        val pokemon: PokemonDTO
        runBlocking(Dispatchers.IO) {
            pokemon = pokeAPI.getSinglePokemon(1)
        }

        // Assert
        assertNotNull(pokemon)
        assertEquals("bulbasaur", pokemon.name)
        assertEquals(7, pokemon.height)
        assertNotNull(pokemon.sprites.front_default)
        assertEquals(2, pokemon.types.size)
        assertEquals(69, pokemon.weight)
    }
}