package com.example.superheroapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Power

class PowerAdapter(private val powers: List<Power>) :
    RecyclerView.Adapter<PowerAdapter.PowerViewHolder>() {

    class PowerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val powerName: TextView = itemView.findViewById(R.id.power_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PowerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_power, parent, false)
        return PowerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PowerViewHolder, position: Int) {
        holder.powerName.text = powers[position].name
    }

    override fun getItemCount() = powers.size
}