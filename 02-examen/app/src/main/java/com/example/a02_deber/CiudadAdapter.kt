package com.example.a02_deber

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CiudadAdapter(private val ciudades: List<Ciudad>) :
    RecyclerView.Adapter<CiudadAdapter.CiudadViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CiudadViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_2, parent, false)
        return CiudadViewHolder(view)
    }

    override fun onBindViewHolder(holder: CiudadViewHolder, position: Int) {
        val ciudad = ciudades[position]
        holder.bind(ciudad)
    }

    override fun getItemCount(): Int {
        return ciudades.size
    }

    inner class CiudadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val text1: TextView = itemView.findViewById(android.R.id.text1)
        private val text2: TextView = itemView.findViewById(android.R.id.text2)

        fun bind(ciudad: Ciudad) {
            text1.text = ciudad.nombre
            text2.text = "Población: ${ciudad.poblacion}, Área: ${ciudad.area}"
        }
    }
}
