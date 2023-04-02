package com.example.assignment4.Application

import android.app.Application
import com.example.assignment4.LibrarianRoomDatabase
import com.example.assignment4.Repository.BooksRepository

class BooksApplication : Application(){

    val database by lazy { LibrarianRoomDatabase.getDatabase(this) }
    val repository by lazy {BooksRepository(database.bookDao()) }
}