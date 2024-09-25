package com.example.superheroapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Enemy

class EnemyAdapter(private var enemies: List<Enemy>) : RecyclerView.Adapter<EnemyAdapter.EnemyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnemyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_enemy, parent, false)
        return EnemyViewHolder(view)
    }

    override fun onBindViewHolder(holder: EnemyViewHolder, position: Int) {
        val enemy = enemies[position]
        holder.enemyName.text = enemy.name
        holder.enemyPhoto.setImageResource(enemy.photo)
    }

    override fun getItemCount(): Int = enemies.size


    fun updateEnemies(newEnemies: List<Enemy>) {
        enemies = newEnemies
        notifyDataSetChanged()
    }

    class EnemyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val enemyName: TextView = itemView.findViewById(R.id.enemy_name)
        val enemyPhoto: ImageView = itemView.findViewById(R.id.enemy_photo)
    }
}