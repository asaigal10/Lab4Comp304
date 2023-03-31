package com.example.assignment4.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Librarian")
data class Librarian(
    @PrimaryKey @ColumnInfo val librarianID: Int,
    @ColumnInfo val firstName: String,
    @ColumnInfo val lastName: String,
    @ColumnInfo val password: String
)