package com.innowise.listpokeapi.domain.di

import com.innowise.listpokeapi.domain.api.PokeAPI
import com.innowise.listpokeapi.domain.api.SimplePokeAPI
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://pokeapi.co/api/v2/"

@Module
class RetrofitModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePokemonApi(retrofit: Retrofit): PokeAPI {
        return retrofit.create(PokeAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideSimplePokemonApi(pokeAPI: PokeAPI): SimplePokeAPI {
        return SimplePokeAPI()
    }
}