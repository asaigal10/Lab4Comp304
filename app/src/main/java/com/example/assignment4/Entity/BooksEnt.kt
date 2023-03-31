package com.example.assignment4.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Books")
data class Books(
    @PrimaryKey @ColumnInfo val bookID: Int,
    @ColumnInfo val bookName: String,
    @ColumnInfo val authorName: String,
    @ColumnInfo val bookDescription: String,
    @ColumnInfo val category: String,
    @ColumnInfo val quantity: Int
)