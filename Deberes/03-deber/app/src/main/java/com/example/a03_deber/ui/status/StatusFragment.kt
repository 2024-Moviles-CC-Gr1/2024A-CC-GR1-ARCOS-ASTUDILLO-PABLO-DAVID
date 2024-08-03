package com.example.a03_deber.ui.status

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a03_deber.databinding.FragmentStatusBinding

class StatusFragment : Fragment() {

    private var _binding: FragmentStatusBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatusBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val statusList = listOf(
            Status("https://randomuser.me/api/portraits/men/1.jpg", "My Status", false),
            Status("https://randomuser.me/api/portraits/women/2.jpg", "Jane Smith", true),
            // Add more statuses as needed
        )

        binding.recyclerViewStatuses.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewStatuses.adapter = StatusAdapter(statusList)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
