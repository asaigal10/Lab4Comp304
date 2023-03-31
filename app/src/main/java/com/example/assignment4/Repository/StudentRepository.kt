package com.example.assignment4.Repository

import androidx.lifecycle.LiveData
import com.example.assignment4.Entity.Student
import com.example.assignment4.dao.StudentDao

class StudentRepository(private val studentDao: StudentDao) {

    suspend fun getStudentById(studentId: Int): LiveData<com.example.assignment4.Entity.Student> {
        return studentDao.getStudentById(studentId)
    }

    suspend fun insert(student: Student) {
        studentDao.insert(student)
    }

    suspend fun update(student: Student) {
        studentDao.update(student)
    }

    suspend fun delete(student: Student) {
        studentDao.delete(student)
    }

    suspend fun borrowBook(studentId: Int, bookId: Int) {
        studentDao.borrowBookAddToStudent(studentId, bookId)
    }
}