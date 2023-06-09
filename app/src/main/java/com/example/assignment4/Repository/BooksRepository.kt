package com.example.assignment4.Repository

import androidx.lifecycle.LiveData
import com.example.assignment4.Book
import com.example.assignment4.Entity.Books
import com.example.assignment4.dao.BooksDao

class BooksRepository(private val booksDao: BooksDao) {

    val allBooks: LiveData<List<Book>> = booksDao.getAllBooks()

    suspend fun insert(book: Books) {
        booksDao.insert(book)
    }

    suspend fun update(book: Books) {
        booksDao.update(book)
    }

    suspend fun delete(book: Books) {
        booksDao.delete(book)
    }

     fun getBooksByCategory(category: String): LiveData<List<Book>> {
        return booksDao.getBooksByCategory(category)
    }

     fun getBookById(bookId: Int): LiveData<Book> {
        return booksDao.getBookById(bookId)
    }

    suspend fun borrowBook(bookId: Int) {
        booksDao.borrowBook(bookId)
    }

    suspend fun returnBook(bookId: Int){
        booksDao.returnBook(bookId)
    }
}