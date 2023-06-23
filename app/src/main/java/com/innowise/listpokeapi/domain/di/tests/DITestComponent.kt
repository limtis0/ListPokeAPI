package com.innowise.listpokeapi.domain.di.tests

import dagger.Component
import javax.inject.Singleton

@Component(modules = [DITestModule::class])
@Singleton
interface DITestComponent {
    fun inject(diTestClass: TestDI)
}
