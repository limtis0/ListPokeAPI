package com.innowise.listpokeapi.domain.di

import com.innowise.listpokeapi.domain.api.PokeAPI
import com.innowise.listpokeapi.domain.api.SimplePokeAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class PokemonAPIModule {
    @Provides
    @Singleton
    fun providePokemonApi(retrofit: Retrofit): PokeAPI {
        return retrofit.create(PokeAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideSimplePokemonApi(pokeAPI: PokeAPI): SimplePokeAPI {
        return SimplePokeAPI(pokeAPI)
    }
}