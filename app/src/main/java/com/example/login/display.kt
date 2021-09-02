package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class display : AppCompatActivity() {

    var userList: ArrayList<UserList> = arrayListOf()
    var DB = MyDBHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml)

        inti()
        initRecycler()
    }

    fun inti() {
        var cur = DB.disp()
        while (cur.moveToFirst()) {
            val name = cur.getString(0)
            val email = cur.getString(1)
            val number = cur.getString(2)
            userList.add(UserList(name, email, number))
        }
    }

    fun initRecycler() {
        var recycle: RecyclerView = findViewById(R.id.recycle)
        var LLM: LinearLayoutManager = LinearLayoutManager(this)
        LLM.orientation = RecyclerView.VERTICAL
        recycle.layoutManager = LLM
        var adapter = Adapter(userList)
        recycle.adapter = adapter
    }
}



