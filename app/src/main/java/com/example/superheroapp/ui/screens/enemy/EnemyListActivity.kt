package com.example.superheroapp.ui.screens.enemy


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.adapters.EnemyAdapter
import com.example.superheroapp.databinding.RvEnemyBinding
import com.example.superheroapp.viewModels.EnemyViewModel


class EnemyListActivity : AppCompatActivity() {

    private val enemyViewModel: EnemyViewModel by viewModels()
    private lateinit var binding: RvEnemyBinding
    private lateinit var adapter: EnemyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RvEnemyBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        adapter = EnemyAdapter(emptyList())
        binding.recyclerView.adapter = adapter


        enemyViewModel.enemies.observe(this, Observer { enemies ->
            adapter.updateEnemies(enemies)
        })

        enemyViewModel.loadEnemies()
    }
}