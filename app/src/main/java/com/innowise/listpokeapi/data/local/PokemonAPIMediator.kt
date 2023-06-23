package com.innowise.listpokeapi.data.local

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.innowise.listpokeapi.domain.api.SimplePokeAPI
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class PokemonAPIMediator(
    private val pokemonDB: PokemonDB,
    private val simplePokeAPI: SimplePokeAPI
) : RemoteMediator<Int, PokemonEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PokemonEntity>
    ): MediatorResult {
        return try {
            // Find current page
            val loadKey = when(loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1  // TODO: Fix wrong paging?
                    }
                }
            }

            // Getting the pokemons
            val pokemons = simplePokeAPI.getPokemonsPage(loadKey, state.config.pageSize)

            pokemonDB.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    pokemonDB.dao.clearAll()
                }
                pokemonDB.dao.upsertAll(pokemons)
            }

            MediatorResult.Success(
                endOfPaginationReached = pokemons.isEmpty()
            )

        } catch (e: IOException) {
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        }
    }
}