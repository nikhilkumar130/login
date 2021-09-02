package com.example.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(private val user:ArrayList<UserList>): RecyclerView.Adapter<Adapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.contacts,parent,false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: Adapter.MyViewHolder, position: Int) {
        val name  = user[position].name
        val email = user[position].mail
        val number = user[position].num

        holder.set(name,email,number)

    }

    override fun getItemCount(): Int {
        return user.size
    }
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val name1 = itemView.findViewById<TextView>(R.id.name)
        val mail1 = itemView.findViewById<TextView>(R.id.mail)
        val Num1 = itemView.findViewById<TextView>(R.id.number)

        fun set(name:String?,mail:String?,num:String?){
            name1.text = name
            mail1.text = mail
            Num1.text = num
        }
    }

}