package com.innowise.listpokeapi.domain.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.innowise.listpokeapi.data.local.PokemonAPIMediator
import com.innowise.listpokeapi.data.local.PokemonDB
import com.innowise.listpokeapi.data.local.PokemonEntity
import com.innowise.listpokeapi.domain.api.SimplePokeAPI
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

const val PAGE_SIZE = 20

@Module
class PokemonPagerModule {
    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun providePokemonPager(pokemonDB: PokemonDB, pokemonAPI: SimplePokeAPI):
            Pager<Int, PokemonEntity> {
        return Pager(
            config = PagingConfig(PAGE_SIZE),
            remoteMediator = PokemonAPIMediator(
                pokemonDB = pokemonDB,
                pokemonAPI = pokemonAPI
            ),
            pagingSourceFactory = {
                pokemonDB.dao.pagingSource()
            }
        )
    }
}
