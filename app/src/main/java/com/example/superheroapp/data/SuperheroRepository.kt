package com.example.superheroapp.data

import com.example.superheroapp.data.models.Location
import com.example.superheroapp.data.models.Power
import com.example.superheroapp.data.models.Superhero

class SuperheroRepository {

    fun getSuperheroes(): List<Superhero> {
        return generateSuperheroes()
    }

    fun getLocations(): Map<Int, Location> {
        return generateLocations().associateBy { it.id }
    }

    fun getPowers(): Map<Int, Power> {
        return generatePowers().associateBy { it.id }
    }
}