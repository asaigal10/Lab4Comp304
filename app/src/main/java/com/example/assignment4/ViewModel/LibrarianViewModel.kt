package com.example.assignment4.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment4.Book
import com.example.assignment4.Entity.Librarian
import com.example.assignment4.Repository.LibrarianRepository
import kotlinx.coroutines.launch

class LibrarianViewModel (private val librarianRepository: LibrarianRepository): ViewModel() {

    fun getLibrarianById(librarianId: Int): LiveData<com.example.assignment4.Entity.Librarian> {
        return librarianRepository.getLibrarianById(librarianId)
    }

    fun getAllBooks(): LiveData<List<Book>> {
        return librarianRepository.getAllBooks()
    }

    fun getBooksByCategory(category: String): LiveData<List<Book>> {
        return librarianRepository.getBooksByCategory(category)
    }

    fun insert(librarian: Librarian) {
        viewModelScope.launch {
            librarianRepository.insert(librarian)
        }
    }

    fun update(librarian: Librarian) {
        viewModelScope.launch {
            librarianRepository.update(librarian)
        }
    }

    fun delete(librarian: Librarian) {
        viewModelScope.launch {
            librarianRepository.delete(librarian)
        }
    }

    fun insertBook(book: Book) {
        viewModelScope.launch {
            librarianRepository.insertBook(book)
        }
    }

    fun updateBook(book: Book) {
        viewModelScope.launch {
            librarianRepository.updateBook(book)
        }
    }

    fun deleteBook(book: Book) {
        viewModelScope.launch {
            librarianRepository.deleteBook(book)
        }
    }
}


