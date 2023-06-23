package com.innowise.listpokeapi.domain.di

import com.innowise.listpokeapi.ListPokeAPIApplication
import com.innowise.listpokeapi.domain.api.SimplePokeAPI
import com.innowise.listpokeapi.domain.api.tests.TestAPICalls
import com.innowise.listpokeapi.domain.api.tests.TestSimplifiedAPI
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RetrofitModule::class])
@Singleton
interface ApplicationComponent {
    fun inject(application: ListPokeAPIApplication)
    fun inject(application: SimplePokeAPI)
    fun inject(application: TestAPICalls)
    fun inject(application: TestSimplifiedAPI)

}
