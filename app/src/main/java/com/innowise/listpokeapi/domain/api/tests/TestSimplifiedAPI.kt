package com.innowise.listpokeapi.domain.api.tests

import com.innowise.listpokeapi.data.local.PokemonEntity
import com.innowise.listpokeapi.data.local.PokemonType
import com.innowise.listpokeapi.domain.api.SimplePokeAPI
import com.innowise.listpokeapi.domain.di.DaggerApplicationComponent
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import javax.inject.Inject

class TestSimplifiedAPI {
    @Inject
    lateinit var pokemonAPI: SimplePokeAPI

    @Before
    fun setup() {
        val diAppComponent = DaggerApplicationComponent.builder()
            .pokemonDBModule(Mockito.mock())
            .build()

        diAppComponent.inject(this)
    }

    @Test
    fun testGetPokemonsPage() {
        // Arrange
        val venusaur = PokemonEntity(
            3,
            "Venusaur",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png",
            listOf(PokemonType.GRASS, PokemonType.POISON),
            100.0,
            200.0
        )

        // Act
        val pokemons = runBlocking { pokemonAPI.getPokemonsPage(0, 3) }

        // Assert
        assertEquals(venusaur, pokemons[2])
    }

    @Test
    fun testGetSecondPokemonsPage() {
        // Act
        val pokemons = runBlocking { pokemonAPI.getPokemonsPage(1, 3) }

        // Assert
        assertEquals("Charmander", pokemons[0].name)
    }

    @Test
    fun testGetNonexistentPokemonsPage() {
        // Act
        val pokemons = runBlocking { pokemonAPI.getPokemonsPage(100, 20) }

        // Assert
        assertTrue(pokemons.isEmpty())
    }
}