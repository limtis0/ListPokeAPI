package com.innowise.listpokeapi.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import com.innowise.listpokeapi.ListPokeAPIApplication
import com.innowise.listpokeapi.data.local.PokemonEntity
import javax.inject.Inject

class PokemonListViewModel: ViewModel() {
    @Inject
    lateinit var pager: Pager<Int, PokemonEntity>

    init {
        ListPokeAPIApplication.appComponent.inject(this)
    }

    var pokemonPagingFlow = pager
        .flow
        .cachedIn(viewModelScope)
}