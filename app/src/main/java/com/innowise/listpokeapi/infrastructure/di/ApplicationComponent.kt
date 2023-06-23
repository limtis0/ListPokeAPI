package com.innowise.listpokeapi.infrastructure.di

import com.innowise.listpokeapi.ListPokeAPIApplication
import com.innowise.listpokeapi.infrastructure.api.SimplePokeAPI
import com.innowise.listpokeapi.infrastructure.api.tests.TestAPICalls
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RetrofitModule::class])
@Singleton
interface ApplicationComponent {
    fun inject(application: ListPokeAPIApplication)
    fun inject(application: SimplePokeAPI)

    fun inject(testApp: TestAPICalls)
}
