package com.example.login

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context) :SQLiteOpenHelper(context,"USERDB",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT,UNAME TEXT,NAME TEXT,PWD TEXT,CPWD TEXT)")
        db?.execSQL("CREATE TABLE CONTACTS(USERID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,EMAIL TEXT,NUMBER TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun disp() : Cursor{
        var db1 : SQLiteDatabase = this.writableDatabase
        var cursor : Cursor = db1.rawQuery("SELECT * FROM CONTACTS",null)
        return cursor
    }
}