package com.example.assignment4

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.assignment4.dao.BooksDao
import com.example.assignment4.dao.LibrarianDao
import com.example.assignment4.dao.StudentDao

@Database(entities = [Book::class, Librarian::class, Student::class], version = 1)
public abstract class LibrarianRoomDatabase : RoomDatabase() {
    abstract fun bookDao(): BooksDao
    abstract fun librarianDao() : LibrarianDao
    abstract fun studentDao() : StudentDao

    companion object{
        private const val DATABASE_NAME = "library_db"

        @Volatile
        private var INSTANCE: LibrarianRoomDatabase? = null

        fun getDatabase(context: Context): LibrarianRoomDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LibrarianRoomDatabase::class.java,
                    "library-db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}