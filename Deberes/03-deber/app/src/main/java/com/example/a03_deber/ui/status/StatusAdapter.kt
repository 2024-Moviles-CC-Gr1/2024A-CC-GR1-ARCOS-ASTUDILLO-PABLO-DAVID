package com.example.a03_deber.ui.status

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a03_deber.R
import com.squareup.picasso.Picasso

data class Status(val imageUrl: String, val name: String, val isSeen: Boolean)

class StatusAdapter(private val statusList: List<Status>) : RecyclerView.Adapter<StatusAdapter.StatusViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_status, parent, false)
        return StatusViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatusViewHolder, position: Int) {
        val status = statusList[position]
        Picasso.get()
            .load(status.imageUrl)
            .into(holder.imageViewStatus)
        holder.textViewName.text = status.name
        holder.imageViewAddStatus.visibility = if (position == 0) View.VISIBLE else View.GONE
        holder.imageViewStatus.background = if (status.isSeen)
            holder.itemView.context.getDrawable(R.drawable.border_gray)
        else
            holder.itemView.context.getDrawable(R.drawable.border_green)
    }

    override fun getItemCount() = statusList.size

    class StatusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewStatus: ImageView = itemView.findViewById(R.id.imageViewStatus)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val imageViewAddStatus: ImageView = itemView.findViewById(R.id.imageViewAddStatus)
    }
}
