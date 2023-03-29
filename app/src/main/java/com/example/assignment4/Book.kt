package com.example.assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Book : AppCompatActivity() {
    private lateinit var homescreen2 :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        homescreen2 = findViewById(R.id.Home_Screen_from_Book)

        homescreen2.setOnClickListener {
            Log.i("TAG", "Back To Main Was Clicked")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}