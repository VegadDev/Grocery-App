package com.dev.groceryapp.ui.main.dashboard


import com.dev.groceryapp.data.entity.ShiftEntity
import com.dev.groceryapp.data.entity.StudentEntity

data class DashboardUiState(

    val shiftList: List<ShiftEntity> = emptyList(),
    val staffList: Int = 1,
    val studentList: List<StudentEntity> = emptyList(),

    val totalStudents: Int = 0,
    val totalStaff: Int = 0,
    val totalShift: Int = 1,
)
