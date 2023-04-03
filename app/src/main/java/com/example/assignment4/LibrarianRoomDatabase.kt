package com.example.assignment4

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.assignment4.Entity.Books
import com.example.assignment4.dao.BooksDao
import com.example.assignment4.dao.LibrarianDao
import com.example.assignment4.dao.StudentDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Book::class, Librarian::class, Student::class], version = 1)
    abstract class LibrarianRoomDatabase : RoomDatabase() {
    abstract fun bookDao(): BooksDao
    abstract fun librarianDao() : LibrarianDao
    abstract fun studentDao() : StudentDao

    private class LibrarianDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    // Get an instance of each DAO
                    val booksDao = database.bookDao()
                    val studentDao = database.studentDao()
                    val librarianDao = database.librarianDao()

                    // Delete all content from each table
                    booksDao.deleteAll()
                    studentDao.deleteAll()
                    librarianDao.deleteAll()

                    // Add sample books
                    val book1 = Books(
                        bookID = 1,
                        bookName = "To Kill a Mockingbird",
                        authorName = "Harper Lee",
                        bookDescription = "The story of a young girl in Alabama during the 1930s",
                        category = "Fiction",
                        quantity = 5
                    )
                    booksDao.insert(book1)

                    val book2 = Books(
                        bookID = 2,
                        bookName = "The Great Gatsby",
                        authorName = "F. Scott Fitzgerald",
                        bookDescription = "The story of a millionaire and his obsession with a woman",
                        category = "Fiction",
                        quantity = 8
                    )
                    booksDao.insert(book2)


                    // Add sample students
                    val student1 = com.example.assignment4.Entity.Student(
                        studentId = 1,
                        firstName = "John",
                        lastName = "Halo",
                        password = "masterChief117"
                    )
                    studentDao.insert(student1)

                    val student2 = com.example.assignment4.Entity.Student(
                        studentId = 2,
                        firstName = "Carl",
                        lastName = "Johnson",
                        password = "SanAndreas",
                    )
                    studentDao.insert(student2)

                    // Add sample librarians
                    val librarian1 = com.example.assignment4.Entity.Librarian(
                        librarianID = 1,
                        firstName = "Yash",
                        lastName = "Sheth",
                        password = "COMP304"
                    )
                    librarianDao.insert(librarian1)

                    val librarian2 = com.example.assignment4.Entity.Librarian(
                        librarianID = 7,
                        firstName = "James",
                        lastName = "Bond",
                        password = "CasinoRoyale"
                    )
                    librarianDao.insert(librarian2)
                }
            }
        }
    }
    companion object {
        @Volatile
        private var INSTANCE: LibrarianRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): LibrarianRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LibrarianRoomDatabase::class.java,
                    "library_db"
                )
                    .addCallback(LibrarianDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

    }
}