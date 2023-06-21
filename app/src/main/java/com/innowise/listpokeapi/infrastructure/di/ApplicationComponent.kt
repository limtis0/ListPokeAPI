package com.innowise.listpokeapi.infrastructure.di

import com.innowise.listpokeapi.ListPokeAPIApplication
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RetrofitModule::class])
@Singleton
interface ApplicationComponent {
    fun inject(application: ListPokeAPIApplication)
}
