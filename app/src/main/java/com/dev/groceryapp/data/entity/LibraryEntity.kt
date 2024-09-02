package com.dev.groceryapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "library")
data class LibraryEntity(
  @PrimaryKey(autoGenerate = false)
  val libraryId: Int,
  val userId: Int,
  val key: String,
  val name: String,
  val mobile:String?=null,
  val imgUrl: String?=null,
  val address: String,
  val totalSpace: Int,
  val lastModified: Long
)