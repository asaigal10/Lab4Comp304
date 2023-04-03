package com.example.assignment4.Application

import android.app.Application
import com.example.assignment4.LibrarianRoomDatabase
import com.example.assignment4.Repository.BooksRepository
import com.example.assignment4.Repository.StudentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class StudentApplication: Application() {
    val repository by lazy { StudentRepository(database.studentDao()) }
    val applicationScope = CoroutineScope(Dispatchers.Default)
    val database by lazy { LibrarianRoomDatabase.getDatabase(this, applicationScope) }
}