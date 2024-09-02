package com.dev.groceryapp.repository

import com.dev.groceryapp.data.dao.DataDao
import com.dev.groceryapp.data.entity.ShiftEntity
import com.dev.groceryapp.data.entity.StaffEntity
import com.dev.groceryapp.data.entity.StudentEntity
import javax.inject.Inject

interface DataRepository {

    suspend fun getStaffById(editStaffId: Int): StaffEntity
    suspend fun getStudentById(editStudentId: Int): StudentEntity
    suspend fun getShiftById(editShiftId: Int): ShiftEntity

    suspend fun getShiftName(): List<String>

    suspend fun getTotalStudents(): Int
    suspend fun getTotalShifts(): Int
    suspend fun getTotalStaffs(): Int

}

class DataRepositoryImpl
@Inject
constructor(
    private val dataDao: DataDao,
) : DataRepository {

    override suspend fun getStaffById(editStaffId: Int): StaffEntity {
        return dataDao.getStaffById(editStaffId)
    }

    override suspend fun getStudentById(editStudentId: Int): StudentEntity {
        return dataDao.getStudentById(editStudentId)
    }

    override suspend fun getShiftById(editShiftId: Int): ShiftEntity {
        return dataDao.getShiftById(editShiftId)
    }

    override suspend fun getShiftName(): List<String> {
        return dataDao.getAllShiftName()
    }


//    override fun getStaffList(): Flow<List<Staff>> = dataDao.getAllStaff().map { entities ->
//        entities.map { entity ->
//            Staff(
//                staffId = entity.staffId,
//                libraryId = entity.libraryId,
//                pic = entity.pic,
//                name = entity.name,
//                dob = entity.dob,
//                address = entity.address,
//                mobile = entity.mobile,
//                password = entity.password,
//                lastModified = entity.lastModified
//            )
//        }
//    }

    override suspend fun getTotalStudents(): Int {
        return dataDao.getTotalStudents()
    }

    override suspend fun getTotalShifts(): Int {
        return dataDao.getTotalShifts()
    }

    override suspend fun getTotalStaffs(): Int {
        return dataDao.getTotalStaffs()
    }
}
