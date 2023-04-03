package com.example.assignment4.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment4.Book
import com.example.assignment4.Entity.Books
import com.example.assignment4.Repository.BooksRepository
import kotlinx.coroutines.launch

class BooksViewModel (private val booksRepository: BooksRepository) : ViewModel(){

    val allBooks: LiveData<List<Book>> = booksRepository.allBooks

    fun getBooksByCategory(category: String): LiveData<List<Book>> {
        return booksRepository.getBooksByCategory(category)
    }

    fun getBookById(bookId: Int): LiveData<Book> {
        return booksRepository.getBookById(bookId)
    }

    fun borrowBook(bookId: Int) {
        viewModelScope.launch {
            booksRepository.borrowBook(bookId)
        }
    }

    fun returnBook(bookId: Int) {
        viewModelScope.launch {
            booksRepository.returnBook(bookId)
        }
    }

    fun insertBook(book: Books) {
        viewModelScope.launch {
            booksRepository.insert(book)
        }
    }

    fun updateBook(book: Books) {
        viewModelScope.launch {
            booksRepository.update(book)
        }
    }

    fun deleteBook(book: Books) {
        viewModelScope.launch {
            booksRepository.delete(book)
        }
    }
}