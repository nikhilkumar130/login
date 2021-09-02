package com.example.login


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_homescreen.*


class Homescreen : AppCompatActivity() {
    companion object{
        const val NAME = "NAME"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)
        val name=intent.getStringExtra(NAME)
        tv.text="Welcome\n"+name
        dis.setOnClickListener{
            var intent=Intent(this,com.example.login.display::class.java)
            startActivity(intent)
        }
        add.setOnClickListener {
            tv.text="Welcome\n"+name
            var intent = Intent(this,AddContacts::class.java)
            startActivity(intent)
        }
        sout.setOnClickListener {
            var okay= Intent(this,MainActivity::class.java)
            startActivity(okay)
            Toast.makeText(this,"Welcome back",Toast.LENGTH_LONG).show()
            }
    }
}