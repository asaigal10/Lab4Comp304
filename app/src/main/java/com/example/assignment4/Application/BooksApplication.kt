package com.example.assignment4.Application

import android.app.Application
import com.example.assignment4.LibrarianRoomDatabase
import com.example.assignment4.Repository.BooksRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class BooksApplication : Application(){

    val repository by lazy {BooksRepository(database.bookDao()) }
    val applicationScope = CoroutineScope(Dispatchers.Default)
    val database by lazy { LibrarianRoomDatabase.getDatabase(this, applicationScope) }
}

