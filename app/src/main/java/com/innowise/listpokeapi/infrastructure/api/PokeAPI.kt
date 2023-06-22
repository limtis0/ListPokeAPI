package com.innowise.listpokeapi.infrastructure.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.innowise.listpokeapi.data.models.api.PokemonNameUrlList
import com.innowise.listpokeapi.data.models.api.PokemonWrapper

interface PokeAPI {
    @GET("pokemon/")
    suspend fun getPokemons(
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): PokemonNameUrlList

    @GET("pokemon/{id}/")
    suspend fun getSinglePokemon(
        @Path("id") id: Int
    ): PokemonWrapper
}
