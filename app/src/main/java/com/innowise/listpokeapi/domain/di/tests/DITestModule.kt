package com.innowise.listpokeapi.domain.di.tests

import dagger.Provides
import javax.inject.Singleton
import org.mockito.Mockito.mock
import retrofit2.Retrofit
import com.innowise.listpokeapi.domain.api.PokeAPI
import dagger.Module

@Module
class DITestModule {
    @Provides
    fun provideMockRetrofit(): Retrofit {
        return mock(Retrofit::class.java)
    }

    @Provides
    @Singleton
    fun provideMockPokeApi(): PokeAPI {
        return mock(PokeAPI::class.java)
    }
}
