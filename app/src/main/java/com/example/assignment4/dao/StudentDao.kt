package com.example.assignment4.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.assignment4.Book
import com.example.assignment4.Entity.Student

@Dao
interface StudentDao {
    @Query("SELECT * FROM Student WHERE studentId = :studentId")
    suspend fun getStudentById(studentId: Int): LiveData<Student>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(student: Student)

    @Update
    suspend fun update(student: Student)

    @Delete
    suspend fun delete(student: Student)

    @Query("UPDATE Books SET quantity = quantity - 1 WHERE bookID =:bookID and quantity > 0")
    suspend fun borrowBook(bookID: Int)

    @Query("SELECT * FROM Books where category = :category AND quantity > 0")
    suspend fun getAvailableBooksByCategory (category: String): LiveData<List<Book>>

    @Query("SELECT * From Books WHERE bookID = :bookID AND quantity > 0")
    suspend fun getAvailableBookById(bookID: Int): LiveData<Book>

    suspend fun borrowBookAddToStudent (studentId: Int, bookID: Int){
        borrowBook(bookID)
        val student = getStudentById(studentId).value ?: throw Exception("Student not found")
        student.bookID = bookID
        update(student)
    }
}