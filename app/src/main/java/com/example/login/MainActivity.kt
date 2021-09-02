package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var helper = MyDBHelper(applicationContext)
        var db =helper.readableDatabase
        button1.setOnClickListener {
            var args= listOf<String>(etuser.text.toString(),etpswrd.text.toString()).toTypedArray()
            var rs=db.rawQuery("SELECT * FROM USERS WHERE UNAME=? AND PWD=?",args)
            if(rs.moveToNext()) {
                Toast.makeText(applicationContext, "Welcome", Toast.LENGTH_LONG).show()
                val name=etuser.text.toString()
                var intent = Intent(this, Homescreen::class.java)
                intent.putExtra(Homescreen.NAME,name)
                startActivity(intent)
            }
            else {
                Toast.makeText(applicationContext, "Not Found", Toast.LENGTH_LONG).show()
            }

        }
        button2.setOnClickListener {
            var intent = Intent(this,Register::class.java)
            startActivity(intent)
        }
    }
}