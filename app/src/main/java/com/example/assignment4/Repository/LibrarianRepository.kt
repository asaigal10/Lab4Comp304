package com.example.assignment4.Repository

import androidx.lifecycle.LiveData
import com.example.assignment4.Book
import com.example.assignment4.Librarian
import com.example.assignment4.dao.LibrarianDao

class LibrarianRepository(private val librarianDao: LibrarianDao) {

    fun getLibrarianById(librarianId: Int): LiveData<com.example.assignment4.Entity.Librarian> {
        return librarianDao.getLibrarianById(librarianId)
    }

    suspend fun insert(librarian: Librarian) {
        librarianDao.insert(librarian)
    }

    suspend fun update(librarian: Librarian) {
        librarianDao.update(librarian)
    }

    suspend fun delete(librarian: Librarian) {
        librarianDao.delete(librarian)
    }

    fun getAllBooks(): LiveData<List<Book>> {
        return librarianDao.getAllBooks()
    }

    fun getBooksByCategory(category: String): LiveData<List<Book>> {
        return librarianDao.getBooksByCategory(category)
    }

    suspend fun insertBook(book: Book) {
        librarianDao.insertBook(book)
    }

    suspend fun updateBook(book: Book) {
        librarianDao.updateBook(book)
    }

    suspend fun deleteBook(book: Book) {
        librarianDao.deleteBook(book)
    }
}
