package com.dev.groceryapp.data.typeconverter

import androidx.room.TypeConverter
import java.util.Date

object DateConverter {

    @JvmStatic
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @JvmStatic
    @TypeConverter
    fun toDate(date: Long?): Date? {
        return if (date == null) null else Date(date)
    }

    @JvmStatic
    @TypeConverter
    fun fromString(value: String): Int {
        return value.toIntOrNull() ?: 0
    }

    @JvmStatic
    @TypeConverter
    fun toInt(value: Int): String {
        return value.toString()
    }

}