package com.dev.groceryapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "student")
data class StudentEntity(
    @PrimaryKey(autoGenerate = false)
    val studentId: Int,
    val libraryId: Int,
    val name: String,
    val dob: Date?,
    val gender: Int,
    val address: String,
    val mobile: String,
    val password: String,
    val lastModified: Long
)