package com.innowise.listpokeapi.domain.di

import android.content.Context
import androidx.room.Room
import com.innowise.listpokeapi.data.local.PokemonDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PokemonDBModule(private val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    @Singleton
    fun providePokemonDB() : PokemonDB {
        return Room.databaseBuilder(
            context,
            PokemonDB::class.java,
            "pokemons.db"
        ).build()
    }
}
