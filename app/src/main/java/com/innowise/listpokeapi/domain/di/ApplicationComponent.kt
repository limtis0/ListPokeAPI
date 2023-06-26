package com.innowise.listpokeapi.domain.di

import com.innowise.listpokeapi.ListPokeAPIApplication
import com.innowise.listpokeapi.domain.api.SimplePokeAPI
import com.innowise.listpokeapi.domain.api.tests.TestAPICalls
import com.innowise.listpokeapi.domain.api.tests.TestSimplifiedAPI
import com.innowise.listpokeapi.domain.di.modules.PokemonAPIModule
import com.innowise.listpokeapi.domain.di.modules.PokemonDBModule
import com.innowise.listpokeapi.domain.di.modules.PokemonPagerModule
import com.innowise.listpokeapi.domain.di.modules.RetrofitModule
import com.innowise.listpokeapi.presentation.viewmodels.PokemonListViewModel
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        RetrofitModule::class,
        PokemonAPIModule::class,
        PokemonDBModule::class,
        PokemonPagerModule::class
    ]
)
@Singleton
interface ApplicationComponent {
    fun inject(application: ListPokeAPIApplication)
    fun inject(application: SimplePokeAPI)
    fun inject(application: PokemonListViewModel)
    fun inject(application: TestAPICalls)
    fun inject(application: TestSimplifiedAPI)
}
