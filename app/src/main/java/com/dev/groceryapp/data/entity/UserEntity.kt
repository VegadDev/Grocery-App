package com.dev.groceryapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
  @PrimaryKey(autoGenerate = false)
  val userId: Int,
  val fUid: String,
  val fToken: String?,
  val email: String,
  val name: String,
  val pic: String?,
  val mobile: String?,
  val lastModified: Long,
)