package com.example.assignment4.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Student")
data class Student(
    @PrimaryKey @ColumnInfo val studentId: Int,
    @ColumnInfo val firstName: String,
    @ColumnInfo val lastName: String,
    @ColumnInfo val password: String,
)