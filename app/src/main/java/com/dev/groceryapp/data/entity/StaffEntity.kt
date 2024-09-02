package com.dev.groceryapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "staff")
data class StaffEntity(
  @PrimaryKey(autoGenerate = false)
  val staffId: Int,
  val libraryId: Int,
  val pic: String?,
  val name: String,
  val dob: Date?,
  val address: String?,
  val mobile: String?,
  val password: String,
  val lastModified: Long
)