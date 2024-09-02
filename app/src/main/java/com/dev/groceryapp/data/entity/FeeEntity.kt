package com.dev.groceryapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "fee")
data class FeeEntity(
  @PrimaryKey(autoGenerate = false)
  val feeId: Int,
  val libraryId: Int,
  val studentShiftId: Int,
  val shiftId: Int,
  val studentId: Int,
  val amount: Double,
  val paymentDate: Date,
  val fromDate: Date,
  val toDate: Date,
  val remark: String,
  val lastModified: Long
)