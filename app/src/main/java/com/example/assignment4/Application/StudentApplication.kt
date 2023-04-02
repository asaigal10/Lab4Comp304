package com.example.assignment4.Application

import android.app.Application
import com.example.assignment4.LibrarianRoomDatabase
import com.example.assignment4.Repository.StudentRepository

class StudentApplication: Application() {
    val database by lazy { LibrarianRoomDatabase.getDatabase(this) }
    val repository by lazy {StudentRepository(database.studentDao())}
}