package com.example.assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var Student_btn :Button
    lateinit var Book_btn :Button
  lateinit var Librarian_btn: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      Student_btn = findViewById(R.id.Student_Page)
        Book_btn = findViewById(R.id.Book_Page)
        Librarian_btn = findViewById(R.id.Librarian_Page)

        Student_btn.setOnClickListener {
            Log.i("TAG", "The Student Page  Button was Clicked")
            val itent = Intent(this, Student::class.java)
            startActivity(itent)
        }
        Book_btn.setOnClickListener {
            Log.i("TAG", "The Book Page Button was Clicked")
            val intent = Intent(this, Book::class.java)
            startActivity(intent)
        }
            Librarian_btn.setOnClickListener {
            Log.i("TAG", "The Librarian Page Button was Clicked")
            val intent = Intent(this, Librarian::class.java)
            startActivity(intent)
        }

    }
}