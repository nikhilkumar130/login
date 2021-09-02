package com.example.login

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_contacts.*
import kotlinx.android.synthetic.main.activity_homescreen.*

class AddContacts : AppCompatActivity() {
    companion object{
        const val NAME = "NAME"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contacts)
        var helper=MyDBHelper(applicationContext)
        var db=helper.readableDatabase
        val name=intent.getStringExtra(Homescreen.NAME)
//        var rs=db.rawQuery("SELECT * FROM CONTACTS",null)
        addcontact.setOnClickListener {
            Toast.makeText(this,"Contact saved",Toast.LENGTH_LONG).show()
            tv.text="Welcome\n"+name
            var a=ContentValues()
            a.put("NAME",etaddname.text.toString())
            a.put("EMAIL",etaddemail.text.toString())
            a.put("NUMBER",etaddnumber.text.toString())
            db.insert("CONTACTS",null,a)
            var intent= Intent(this,Homescreen::class.java)
            startActivity(intent)
        }
    }
}