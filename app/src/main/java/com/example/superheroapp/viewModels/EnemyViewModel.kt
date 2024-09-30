package com.example.superheroapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.data.generateEnemies
import com.example.superheroapp.uiStates.EnemiesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EnemyViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(EnemiesUiState())
    val uiState: StateFlow<EnemiesUiState> = _uiState

    init {
        loadEnemies()
    }

    fun loadEnemies() {
        _uiState.value = EnemiesUiState(isLoading = true)

        viewModelScope.launch {
            try {
                val enemies = generateEnemies()
                _uiState.value = EnemiesUiState(enemies = enemies, isLoading = false)
            } catch (e: Exception) {
                _uiState.value = EnemiesUiState(errorMessage = "Error al cargar los enemigos", isLoading = false)
            }
        }
    }
}