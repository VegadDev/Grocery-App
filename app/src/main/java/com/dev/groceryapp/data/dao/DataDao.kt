package com.dev.groceryapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import com.dev.groceryapp.data.entity.ShiftEntity
import com.dev.groceryapp.data.entity.StaffEntity
import com.dev.groceryapp.data.entity.StudentEntity
import com.dev.groceryapp.data.entity.StudentShiftEntity

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(toEntity: StaffEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertStudent(toEntity: StudentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertStudentShift(toEntity: StudentShiftEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertShift(toEntity: ShiftEntity)

    @Query("SELECT * FROM staff")
    fun getAllStaff(): Flow<List<StaffEntity>>

    @Query("SELECT * FROM staff WHERE staffId = :editStaffId")
    suspend fun getStaffById(editStaffId: Int): StaffEntity

    @Query("SELECT * FROM student")
    fun getAllStudent(): Flow<List<StudentEntity>>

    @Query("SELECT * FROM student WHERE studentId = :editStudentId")
    suspend fun getStudentById(editStudentId: Int): StudentEntity

    @Query("SELECT * FROM shift")
    fun getAllShift(): Flow<List<ShiftEntity>>

    @Query("SELECT * FROM shift WHERE shiftId = :editShiftId")
    suspend fun getShiftById(editShiftId: Int): ShiftEntity

    @Query("SELECT name FROM shift")
    fun getAllShiftName(): List<String>

    @Query("SELECT COUNT(*) FROM student")
    suspend fun getTotalStudents(): Int

    @Query("SELECT COUNT(*) FROM shift")
    suspend fun getTotalShifts(): Int

    @Query("SELECT COUNT(*) FROM staff")
    suspend fun getTotalStaffs(): Int

}