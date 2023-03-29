package com.example.assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Librarian : AppCompatActivity() {
    lateinit var homescreen3 :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_librarian)

        homescreen3 =findViewById(R.id.Home_Screen_from_Librarian)

        homescreen3.setOnClickListener {
            Log.i("TAG", "Back To Main Was Clicked")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}