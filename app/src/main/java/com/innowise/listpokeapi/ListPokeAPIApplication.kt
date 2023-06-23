package com.innowise.listpokeapi

import android.app.Application
import com.innowise.listpokeapi.domain.di.ApplicationComponent
import com.innowise.listpokeapi.domain.di.DaggerApplicationComponent


class ListPokeAPIApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.create()
    }
}
