package com.example.kontactroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kontactroom.databinding.FragmentBlank1Binding

class BlankFragment1 : Fragment() {
    lateinit var binding: FragmentBlank1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank1, container, false)
        binding = FragmentBlank1Binding.bind(view)

        binding.allContact.setOnClickListener {
            findNavController().navigate(R.id.blankFragment4)
        }
        binding.addContact.setOnClickListener {
            findNavController().navigate(R.id.blankFragment2)
        }
        return view
    }
}