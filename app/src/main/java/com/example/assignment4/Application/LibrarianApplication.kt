package com.example.assignment4.Application

import android.app.Application
import com.example.assignment4.LibrarianRoomDatabase
import com.example.assignment4.Repository.BooksRepository
import com.example.assignment4.Repository.LibrarianRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class LibrarianApplication: Application() {

    val repository by lazy { LibrarianRepository(database.librarianDao()) }
    val applicationScope = CoroutineScope(Dispatchers.Default)
    val database by lazy { LibrarianRoomDatabase.getDatabase(this, applicationScope) }
}
