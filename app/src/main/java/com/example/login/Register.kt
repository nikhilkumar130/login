package com.example.login

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var helper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase
//        var rs = db.rawQuery("SELECT * FROM USERS", null)
        etregister.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(etregister.text.toString()).matches())
                    register.isEnabled=true
                else{
                    register.isEnabled=false
                    etregister.setError("invalid Email")
                }

            }
        })
        register.setOnClickListener {
            if (etregister2.text.toString() == etregister3.text.toString()) {
                var a = ContentValues()
                a.put("UNAME", etregister.text.toString())
                a.put("NAME", etregister1.text.toString())
                a.put("PWD", etregister2.text.toString())
                a.put("CPWD", etregister3.text.toString())
                db.insert("USERS", null, a)
                etregister.setText("")
                etregister1.setText("")
                etregister2.setText("")
                etregister3.setText("")
                etregister.requestFocus()
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else{
                Toast.makeText(this,"Check Your Details",Toast.LENGTH_SHORT).show()
            }
        }
    }
}