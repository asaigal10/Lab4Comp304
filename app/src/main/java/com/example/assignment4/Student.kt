package com.example.assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.widget.ButtonBarLayout

class Student : AppCompatActivity() {
lateinit var homescreen1 :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

   homescreen1 = findViewById(R.id.Home_Screen_from_Student)


       homescreen1.setOnClickListener {
            Log.i("TAG", "Back To Main Was Clicked")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}