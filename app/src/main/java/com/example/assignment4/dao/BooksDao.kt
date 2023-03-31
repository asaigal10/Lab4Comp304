package com.example.assignment4.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.assignment4.Book

@Dao
interface BooksDao {

    @Query("SELECT * FROM Books")
    fun getAllBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM Books WHERE bookId = :bookId")
    fun getBookById(bookId: Int): LiveData<Book>

    @Query("SELECT * FROM Books WHERE category = :category")
    fun getBooksByCategory(category: String): LiveData<List<Book>>

    @Query("UPDATE Books SET quantity = quantity + 1 WHERE bookId = :bookId")
    suspend fun returnBook(bookId: Int)

    @Update
    suspend fun borrowBook(book: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: Book)

    @Update
    suspend fun update(book: Book)

    @Delete
    suspend fun delete(book: Book)
}