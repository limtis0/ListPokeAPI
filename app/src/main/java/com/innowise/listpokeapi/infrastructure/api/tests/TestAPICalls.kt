package com.innowise.listpokeapi.infrastructure.api.tests

import com.innowise.listpokeapi.data.models.api.PokemonNameUrlList
import com.innowise.listpokeapi.data.models.api.PokemonWrapper
import com.innowise.listpokeapi.infrastructure.api.PokeAPI
import com.innowise.listpokeapi.infrastructure.di.DaggerApplicationComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

// Testing whether API calls are working as intended
class TestAPICalls {
    @Inject
    lateinit var pokeAPI: PokeAPI

    @Before
    fun setup() {
        val diTestComponent = DaggerApplicationComponent.create()
        diTestComponent.inject(this)
    }

    @Test
    fun testGetPokemons() {
        val pokemons: PokemonNameUrlList
        runBlocking(Dispatchers.IO) {
            pokemons = pokeAPI.getPokemons(20, 0)
        }

        assertNotNull(pokemons)
        assertTrue(pokemons.count >= 1281)  // 1281, exactly, may change in future
        assertEquals(20, pokemons.results.size)
    }

    @Test
    fun testGetSinglePokemon() {
        val pokemon: PokemonWrapper
        runBlocking(Dispatchers.IO) {
            pokemon = pokeAPI.getSinglePokemon(1)
        }

        assertNotNull(pokemon)
        assertEquals("bulbasaur", pokemon.name)
        assertEquals(7, pokemon.height)
        assertNotNull(pokemon.sprites.front_default)
        assertEquals(2, pokemon.types.size)
        assertEquals(69, pokemon.weight)
    }
}