package com.example.superheroapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.adapters.PowerAdapter
import com.example.superheroapp.data.models.Power

class PowersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_powers)

        val powers = intent.getParcelableArrayListExtra<Power>("powers") ?: emptyList<Power>()

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_powers)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PowerAdapter(powers)
    }
}