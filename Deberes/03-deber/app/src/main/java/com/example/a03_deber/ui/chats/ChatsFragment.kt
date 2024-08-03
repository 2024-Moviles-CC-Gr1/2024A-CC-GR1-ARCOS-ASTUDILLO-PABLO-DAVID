package com.example.a03_deber.ui.chats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a03_deber.databinding.FragmentChatsBinding

class ChatsFragment : Fragment() {

    private var _binding: FragmentChatsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val chatsViewModel = ViewModelProvider(this).get(ChatsViewModel::class.java)

        _binding = FragmentChatsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recyclerViewChats.layoutManager = LinearLayoutManager(context)
        val adapter = ChatsAdapter()
        binding.recyclerViewChats.adapter = adapter

        chatsViewModel.chats.observe(viewLifecycleOwner) { chats ->
            adapter.submitList(chats)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
