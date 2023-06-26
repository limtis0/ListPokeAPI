package com.innowise.listpokeapi.domain.di.tests

import com.innowise.listpokeapi.domain.remote.PokeAPI
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import javax.inject.Inject

class TestDI {
    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var pokeAPI: PokeAPI

    @Before
    fun setup() {
        val diTestComponent = DaggerDITestComponent.create()
        diTestComponent.inject(this)
    }

    @Test
    fun testInjection() {
        assertNotNull(retrofit)
        assertNotNull(pokeAPI)
    }
}