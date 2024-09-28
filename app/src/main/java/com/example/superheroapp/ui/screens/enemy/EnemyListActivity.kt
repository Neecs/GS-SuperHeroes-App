package com.example.superheroapp.ui.screens.enemy


import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.adapters.EnemyAdapter
import com.example.superheroapp.viewModels.EnemyViewModel
import kotlinx.coroutines.launch


class EnemyListActivity : AppCompatActivity() {
    private val enemyViewModel: EnemyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rv_enemy)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val progressBar: View = findViewById(R.id.pb_characters)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            enemyViewModel.uiState.collect { uiState ->
                if (uiState.isLoading) {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.INVISIBLE
                } else {
                    progressBar.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                    recyclerView.adapter = EnemyAdapter(uiState.enemies)
                }
            }
        }
    }
}
