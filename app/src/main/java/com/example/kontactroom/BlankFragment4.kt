package com.example.kontactroom

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kontactroom.adapter.UserAdapter
import com.example.kontactroom.databinding.FragmentBlank3Binding
import com.example.kontactroom.databinding.FragmentBlank4Binding
import com.example.kontactroom.databinding.UserDialogBinding
import com.example.kontactroom.databinding.UserItemBinding
import com.example.kontactroom.db.DataBaseServis
import com.example.kontactroom.user.User

class BlankFragment4 : Fragment() {
    lateinit var binding: FragmentBlank4Binding
    lateinit var userDatabase: UserDatabase
    lateinit var adapter: UserAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank4, container, false)
        binding = FragmentBlank4Binding.bind(view)

        userDatabase = UserDatabase.getInstance(requireContext())
        val userDao: DataBaseServis = userDatabase.userDao()

        val list = userDao.getAllUsers() as ArrayList
        adapter = UserAdapter(list, object : UserAdapter.OnClickListener {
            override fun onCilc(user: User, position: Int) {
                val bundle = Bundle().apply {
                    putSerializable("user", user)
                }
                findNavController().navigate(R.id.blankFragment3, bundle)
            }

            override fun itemRemove(user: User, position: Int) {
                val alertDialog = AlertDialog.Builder(requireContext())
                alertDialog.setTitle("Uchirish")
                alertDialog.setMessage("Bu kontakt malumotlari uchirilsinmi")
                alertDialog.setCancelable(true)

                alertDialog.setPositiveButton(
                    "Ha"
                ) { p0, p1 ->
                    userDao.deleteUser(user)
                    list.removeAt(position)
                    adapter.notifyItemRemoved(position)
                    adapter.notifyItemRangeChanged(position, list.size)
                }
                alertDialog.show()
            }

            override fun itemEdit(user: User, position: Int) {
                val alertDialog = AlertDialog.Builder(requireContext())
                alertDialog.setTitle("Uzgartirish")
                alertDialog.setCancelable(true)
                val view = layoutInflater.inflate(R.layout.user_dialog, null, false)
                alertDialog.setView(view)
                val bind = UserDialogBinding.bind(view)

                bind.name.setText(user.name)
                bind.number.setText(user.name)

                alertDialog.setPositiveButton("Save") { p0, p1 ->
                    val name = bind.name.text.toString()
                    val number = bind.number.text.toString()
                    user.name = name
                    user.phoneNumber = number
                    list[position] = user
                    userDao.editUser(user)
                    adapter.notifyItemChanged(position)
                }
                alertDialog.show()
            }
        })
        binding.ervi.adapter = adapter
        return view
    }
}