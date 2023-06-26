package com.innowise.listpokeapi.domain.di.modules

import com.innowise.listpokeapi.domain.remote.PokeAPI
import com.innowise.listpokeapi.domain.remote.SimplePokeAPI
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