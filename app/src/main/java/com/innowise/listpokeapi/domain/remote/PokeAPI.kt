package com.innowise.listpokeapi.domain.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.innowise.listpokeapi.data.remote.PokemonNameUrlList
import com.innowise.listpokeapi.data.remote.PokemonDTO

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
