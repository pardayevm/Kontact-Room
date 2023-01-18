package com.example.kontactroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kontactroom.databinding.FragmentBlank3Binding
import com.example.kontactroom.user.User

class BlankFragment3 : Fragment() {
    lateinit var binding: FragmentBlank3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank3, container, false)
        binding = FragmentBlank3Binding.bind(view)

        val user: User = arguments?.getSerializable("user") as User

        binding.nameTextView.text = user.name
        binding.numberTextView.text = user.phoneNumber


        return view
    }
}