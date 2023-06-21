package com.innowise.listpokeapi

import android.app.Application
import com.innowise.listpokeapi.infrastructure.di.ApplicationComponent
import com.innowise.listpokeapi.infrastructure.di.DaggerApplicationComponent


class ListPokeAPIApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.create()
    }
}
