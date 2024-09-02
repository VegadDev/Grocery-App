package com.dev.groceryapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "studentShift")
data class StudentShiftEntity(
  @PrimaryKey(autoGenerate = false)
  val studentShiftId: Int,
  val shiftId: Int,
  val studentId: Int,
  val seatNo: Int,
  val feeType: Int,
  val amount: Double,
  val startTime: Int,
  val endTime: Int,
  val joinDate: Date,
  val finishDate: Date?,
  val lastModified: Long
)