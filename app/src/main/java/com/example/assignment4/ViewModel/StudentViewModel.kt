package com.example.assignment4.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment4.Repository.StudentRepository
import com.example.assignment4.Entity.Student
import kotlinx.coroutines.launch

class StudentViewModel (private val repository: StudentRepository): ViewModel(){

    suspend fun getStudentById(studentId: Int): LiveData<com.example.assignment4.Entity.Student> {
        return repository.getStudentById(studentId)
    }

    fun insert(student: Student) {
        viewModelScope.launch {
            repository.insert(student)
        }
    }

    fun update(student: Student) {
        viewModelScope.launch {
            repository.update(student)
        }
    }

    fun delete(student: Student) {
        viewModelScope.launch {
            repository.delete(student)
        }
    }

    fun borrowBook(studentId: Int, bookId: Int) {
        viewModelScope.launch {
            repository.borrowBook(studentId, bookId)
        }
    }
}


