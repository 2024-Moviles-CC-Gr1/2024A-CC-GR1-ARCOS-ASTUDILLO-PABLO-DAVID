package com.example.a03_deber.ui.calls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a03_deber.databinding.FragmentCallsBinding

class CallsFragment : Fragment() {

    private var _binding: FragmentCallsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val callsViewModel =
            ViewModelProvider(this).get(CallsViewModel::class.java)

        _binding = FragmentCallsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.recyclerViewCalls
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = CallAdapter(callsViewModel.calls.value!!)
        recyclerView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
