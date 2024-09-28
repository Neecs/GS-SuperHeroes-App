package com.example.superheroapp.uiStates

import com.example.superheroapp.data.models.Enemy

data class EnemiesUiState(
    val isLoading: Boolean = false,
    val enemies: List<Enemy> = emptyList(),
    val errorMessage: String? = null
)