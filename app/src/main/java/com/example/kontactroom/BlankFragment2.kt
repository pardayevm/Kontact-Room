package com.example.kontactroom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kontactroom.adapter.UserAdapter
import com.example.kontactroom.databinding.FragmentBlank2Binding
import com.example.kontactroom.db.DataBaseServis
import com.example.kontactroom.user.User

class BlankFragment2 : Fragment() {
    lateinit var binding: FragmentBlank2Binding
    lateinit var userDatabase: UserDatabase
    lateinit var adapter: UserAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank2, container, false)
        binding = FragmentBlank2Binding.bind(view)

        userDatabase = UserDatabase.getInstance(requireContext())
        val userDao: DataBaseServis = userDatabase.userDao()

        val list = userDao.getAllUsers() as ArrayList

        binding.addContact2.setOnClickListener {
            val name = binding.contactName.text.toString()
            val number = binding.contactNumber.text.toString()
            val user = User(name, number)
            userDao.addUser(user)
            val id = userDao.getUserById(name)
            user.id = id
            list.add(user)
            Toast.makeText(requireContext(), "Malumot qushildi", Toast.LENGTH_SHORT).show()
            binding.contactName.text.clear()
            binding.contactNumber.text.clear()
        }
        return view
    }
}