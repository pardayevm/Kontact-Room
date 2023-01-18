package com.example.kontactroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kontactroom.R
import com.example.kontactroom.databinding.UserItemBinding
import com.example.kontactroom.user.User

class UserAdapter(
    private val list: ArrayList<User>,
    val onClickListener: OnClickListener
) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(user: User, position: Int) {
            val bind = UserItemBinding.bind(itemView)
            bind.name.text = user.name
            bind.number.text = user.phoneNumber

            bind.btnDelet.setOnClickListener {
                onClickListener.itemRemove(user, position)
            }
            bind.btnUpdet.setOnClickListener {
                onClickListener.itemEdit(user, position)
            }
            bind.parentItem.setOnClickListener {
                onClickListener.onCilc(user, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size


    interface OnClickListener {
        fun onCilc(user: User, position: Int)
        fun itemRemove(user: User, position: Int)
        fun itemEdit(user: User, position: Int)
    }
}