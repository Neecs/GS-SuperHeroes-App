package com.example.superheroapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superheroapp.data.generateSuperheroes
import com.example.superheroapp.data.generateLocations
import com.example.superheroapp.data.generatePowers
import com.example.superheroapp.uiStates.SuperheroUiState

class SuperheroViewModel : ViewModel() {
    private val _uiState = MutableLiveData<SuperheroUiState>()
    val uiState: LiveData<SuperheroUiState> get() = _uiState

    init {
        loadSuperheroes()
    }

    private fun loadSuperheroes() {
        _uiState.value = SuperheroUiState.Loading
        try {
            val superheroes = generateSuperheroes()
            val locations = generateLocations().associateBy { it.id }
            val powers = generatePowers().associateBy { it.id }
            _uiState.value = SuperheroUiState.Success(superheroes, locations, powers)
        } catch (e: Exception) {
            _uiState.value = SuperheroUiState.Error(e.message ?: "Unknown error")
        }
    }
}