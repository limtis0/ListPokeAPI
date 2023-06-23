package com.innowise.listpokeapi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import com.innowise.listpokeapi.data.local.PokemonEntity
import javax.inject.Inject

class PokemonViewModel @Inject constructor(
    pager: Pager<Int, PokemonEntity>
): ViewModel() {
    var pokemonPagingFlow = pager
        .flow
        .cachedIn(viewModelScope)
}