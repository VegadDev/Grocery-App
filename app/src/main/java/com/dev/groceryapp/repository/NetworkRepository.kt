package com.dev.groceryapp.repository


import com.google.gson.JsonObject
import kotlinx.coroutines.flow.Flow
import com.dev.groceryapp.data.dao.DataDao
import javax.inject.Inject

interface NetworkRepository {

//    fun upsertUser(user: User): Flow<DataState<User>>
//
//    fun upsertLibrary(library: Library): Flow<DataState<UpsertData>>
//
//    fun upsertStaff(staff: Staff): Flow<DataState<UpsertData>>
//
//    fun upsertStudent(student: Student): Flow<DataState<UpsertData>>
//
//    fun upsertStudentShift(studentShift: StudentShift): Flow<DataState<UpsertData>>
//
//    fun upsertShift(shift: Shift): Flow<DataState<UpsertData>>

}

class NetworkRepositoryImpl
@Inject
constructor(
//    private val apis: UpsertApi,
//    private val dataDao: DataDao,
//    private val shareprefs: Shareprefs
) : NetworkRepository {

//    override fun upsertUser(user: User): Flow<DataState<User>> {
//        return suspend {
//            apis.upsertUser(user.toDto())
//        }.executeSafeFlow {
//            shareprefs.setUser(it)
//            return@executeSafeFlow it
//        }
//    }
//
//    override fun upsertLibrary(library: Library): Flow<DataState<UpsertData>> {
//        return suspend {
//            apis.upsertLibrary(JsonObject().apply {
//                addProperty("userId", shareprefs.user!!.userId)
//                addProperty("email", shareprefs.user!!.email)
//                add("library", library.toDto().toJsonObject())
//            })
//        }.executeSafeFlow {
//            shareprefs.setLibrary(library.copy(libraryId = it.id))
//            return@executeSafeFlow it
//        }
//    }
//
//    override fun upsertStaff(staff: Staff): Flow<DataState<UpsertData>> {
//        return suspend {
//            apis.upsertStaff(JsonObject().apply {
//                addProperty("userId", shareprefs.user!!.userId)
//                addProperty("email", shareprefs.user!!.email)
//                add("staff", staff.toDto().toJsonObject())
//            })
//        }.executeSafeFlow {
//            dataDao.upsert(staff.copy(staffId = it.id , lastModified = it.lastModified).toEntity())
//            return@executeSafeFlow it
//        }
//    }
//
//    override fun upsertStudent(student: Student): Flow<DataState<UpsertData>> {
//        return suspend {
//            apis.upsertStudent(JsonObject().apply {
//                addProperty("userId", shareprefs.user!!.userId)
//                addProperty("email", shareprefs.user!!.email)
//                add("student", student.toDto().toJsonObject())
//            })
//        }.executeSafeFlow {
//            dataDao.upsertStudent(student.copy(studentId = it.id , lastModified = it.lastModified).toEntity())
//            return@executeSafeFlow it
//        }
//    }
//
//    override fun upsertStudentShift(studentShift: StudentShift): Flow<DataState<UpsertData>> {
//        return suspend {
//            apis.upsertStudentShift(JsonObject().apply {
//                addProperty("userId", shareprefs.user!!.userId)
//                addProperty("email", shareprefs.user!!.email)
//                add("studentShift", studentShift.toDto().toJsonObject())
//            })
//        }.executeSafeFlow {
//            dataDao.upsertStudentShift(studentShift.copy(studentShiftId = it.id , lastModified = it.lastModified).toEntity())
//            return@executeSafeFlow it
//        }
//    }
//
//    override fun upsertShift(shift: Shift): Flow<DataState<UpsertData>> {
//        return suspend {
//            apis.upsertShift(JsonObject().apply {
//                addProperty("userId", shareprefs.user!!.userId)
//                addProperty("email", shareprefs.user!!.email)
//                add("shift", shift.toDto().toJsonObject())
//            })
//        }.executeSafeFlow {
//            dataDao.upsertShift(shift.copy(shiftId = it.id , lastModified = it.lastModified).toEntity())
//            return@executeSafeFlow it
//        }
//    }

}
