package com.example.superheroapp.uiStates

import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.data.models.Location
import com.example.superheroapp.data.models.Power

sealed class SuperheroUiState {
    object Loading : SuperheroUiState()
    data class Success(
        val superheroes: List<Superhero>,
        val locations: Map<Int, Location>,
        val powers: Map<Int, Power>
    ) : SuperheroUiState()
    data class Error(val message: String) : SuperheroUiState()
}