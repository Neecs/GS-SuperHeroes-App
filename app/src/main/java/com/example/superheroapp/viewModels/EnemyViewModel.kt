package com.example.superheroapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superheroapp.data.generateEnemies
import com.example.superheroapp.data.models.Enemy


class EnemyViewModel : ViewModel() {

    private val _enemies = MutableLiveData<List<Enemy>>()
    val enemies: LiveData<List<Enemy>> = _enemies


    fun loadEnemies() {
        _enemies.value = generateEnemies()
    }
}