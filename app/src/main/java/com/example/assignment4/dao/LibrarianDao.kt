package com.example.assignment4.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.assignment4.Book
import com.example.assignment4.Entity.Librarian

@Dao
interface LibrarianDao {

    @Query("SELECT * FROM Librarian WHERE librarianId = :librarianId")
    fun getLibrarianById(librarianId: Int): LiveData<Librarian>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(librarian: Librarian)

    @Update
    suspend fun update(librarian: Librarian)

    @Delete
    suspend fun delete(librarian: Librarian)

    @Query("SELECT * FROM Books")
    fun getAllBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM Books WHERE category = :category")
    fun getBooksByCategory(category: String): LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: Book)

    @Update
    suspend fun updateBook(book: Book)

    @Query("DELETE FROM Librarian")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteBook(book: Book)
}