package com.example.superheroapp.uiStates

import com.example.superheroapp.data.models.Superhero

sealed class SuperheroUiState {
    object Loading : SuperheroUiState()
    data class Success(val superheroes: List<Superhero>) : SuperheroUiState()
    data class Error(val message: String) : SuperheroUiState()
}