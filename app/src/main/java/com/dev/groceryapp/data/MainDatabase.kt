package com.dev.groceryapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dev.groceryapp.data.dao.DataDao
import com.dev.groceryapp.data.entity.FeeEntity
import com.dev.groceryapp.data.entity.LibraryEntity
import com.dev.groceryapp.data.entity.ShiftEntity
import com.dev.groceryapp.data.entity.StaffEntity
import com.dev.groceryapp.data.entity.StudentEntity
import com.dev.groceryapp.data.entity.StudentShiftEntity
import com.dev.groceryapp.data.typeconverter.DateConverter


@Database(
    entities = [
        FeeEntity::class,
        LibraryEntity::class,
        ShiftEntity::class,
        StaffEntity::class,
        StudentEntity::class,
        StudentShiftEntity::class,
    ], version = 12, exportSchema = false
)
@TypeConverters(
    DateConverter::class,
)
abstract class MainDatabase : RoomDatabase() {

    abstract fun dataDao(): DataDao

    companion object {

        fun getInstance(context: Context, dbName: String): MainDatabase {
            val db = Room.databaseBuilder(context, MainDatabase::class.java, dbName)
                .build()
            db.openHelper.setWriteAheadLoggingEnabled(false)
            return db
        }

    }
}