package com.example.superheroapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superheroapp.data.generateSuperheroes
import com.example.superheroapp.data.models.Superhero
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
            _uiState.value = SuperheroUiState.Success(superheroes)
        } catch (e: Exception) {
            _uiState.value = SuperheroUiState.Error(e.message ?: "Unknown error")
        }
    }
}