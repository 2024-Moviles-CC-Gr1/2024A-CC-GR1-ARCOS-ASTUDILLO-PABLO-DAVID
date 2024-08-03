package com.example.a03_deber.ui.calls

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a03_deber.R
import com.example.a03_deber.databinding.ItemCallBinding
import com.squareup.picasso.Picasso

class CallAdapter(private val calls: List<Call>) :
    RecyclerView.Adapter<CallAdapter.CallViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder {
        val binding = ItemCallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CallViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {
        val call = calls[position]
        holder.bind(call)
    }

    override fun getItemCount(): Int = calls.size

    class CallViewHolder(private val binding: ItemCallBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(call: Call) {
            Picasso.get().load(call.profileImageUrl).into(binding.imageViewProfile)
            binding.textViewName.text = call.name
            binding.textViewTime.text = call.time
            binding.imageViewStatus.setImageResource(
                when {
                    call.isAnswered && call.isIncoming -> R.drawable.ic_arrow_downward_green
                    call.isAnswered && !call.isIncoming -> R.drawable.ic_arrow_upward_green
                    !call.isAnswered && call.isIncoming -> R.drawable.ic_arrow_downward_red
                    else -> R.drawable.ic_arrow_upward_red
                }
            )
        }
    }
}
