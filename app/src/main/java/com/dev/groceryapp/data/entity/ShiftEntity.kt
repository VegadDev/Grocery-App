package com.dev.groceryapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shift")
data class ShiftEntity(
  @PrimaryKey(autoGenerate = false)
  val shiftId: Int,
  val libraryId: Int,
  val name: String,
  val feeType: Int,
  val baseFee: Double,
  val startTime: Int,
  val endTime: Int,
  val lastModified: Long
)