// SuperheroAdapter.kt
package com.example.superheroapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Superhero

class SuperheroAdapter(private val superheroes: List<Superhero>) :
    RecyclerView.Adapter<SuperheroAdapter.SuperheroViewHolder>() {

    class SuperheroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val superheroImage: ImageView = itemView.findViewById(R.id.superhero_image)
        val superheroName: TextView = itemView.findViewById(R.id.superhero_name)
        val buttonPowers: Button = itemView.findViewById(R.id.button_powers)
        val buttonEnemies: Button = itemView.findViewById(R.id.button_enemies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_superhero, parent, false)
        return SuperheroViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        val superhero = superheroes[position]
        holder.superheroImage.setImageResource(superhero.photo)
        holder.superheroName.text = superhero.name
        // Configura los botones según sea necesario
    }

    override fun getItemCount() = superheroes.size
}