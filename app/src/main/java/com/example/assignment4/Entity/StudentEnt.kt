package com.example.assignment4.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "Student",
    foreignKeys = [ForeignKey(entity = Books::class,
        parentColumns = ["bookID"],
        childColumns = ["bookID"],
        onDelete = ForeignKey.CASCADE)]
)
data class Student(
    @PrimaryKey @ColumnInfo(name = "studentId") val studentId: Int,
    @ColumnInfo(name = "firstName") val firstName: String,
    @ColumnInfo(name = "lastName") val lastName: String,
    @ColumnInfo(name = "password") val password: String,
    @ColumnInfo(name = "bookID") var bookID: Int? = null
)
