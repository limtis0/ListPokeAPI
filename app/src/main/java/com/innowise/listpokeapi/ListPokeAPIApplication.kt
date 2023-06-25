package com.innowise.listpokeapi

import android.app.Application
import android.content.Intent
import com.innowise.listpokeapi.domain.di.ApplicationComponent
import com.innowise.listpokeapi.domain.di.DaggerApplicationComponent
import com.innowise.listpokeapi.domain.di.modules.PokemonDBModule


class ListPokeAPIApplication : Application() {
    companion object {
        lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        // Set up DI component
        appComponent = DaggerApplicationComponent.builder()
             .pokemonDBModule(PokemonDBModule(applicationContext))
             .build()

        // Start the main activity
        val intent = Intent(applicationContext, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}
