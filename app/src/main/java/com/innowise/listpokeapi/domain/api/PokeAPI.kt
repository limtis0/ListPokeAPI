package com.innowise.listpokeapi.domain.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.innowise.listpokeapi.data.api.PokemonNameUrlList
import com.innowise.listpokeapi.data.api.PokemonDTO

interface PokeAPI {
    @GET("pokemon/")
    suspend fun getPokemons(
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): PokemonNameUrlList

    @GET("pokemon/{id}/")
    suspend fun getSinglePokemon(
        @Path("id") id: Int
    ): PokemonDTO
}
