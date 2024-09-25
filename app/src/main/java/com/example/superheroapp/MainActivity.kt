package com.example.superheroapp

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.adapters.SuperheroAdapter
import com.example.superheroapp.uiStates.SuperheroUiState
import com.example.superheroapp.viewModels.SuperheroViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: SuperheroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val progressBar: ProgressBar = findViewById(R.id.progress_bar)
        val errorTextView: TextView = findViewById(R.id.error_text_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.uiState.observe(this, Observer { uiState ->
            when (uiState) {
                is SuperheroUiState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                    errorTextView.visibility = View.GONE
                }
                is SuperheroUiState.Success -> {
                    progressBar.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                    errorTextView.visibility = View.GONE
                    recyclerView.adapter = SuperheroAdapter(uiState.superheroes, uiState.locations)
                }
                is SuperheroUiState.Error -> {
                    progressBar.visibility = View.GONE
                    recyclerView.visibility = View.GONE
                    errorTextView.visibility = View.VISIBLE
                    errorTextView.text = uiState.message
                }
            }
        })
    }
}