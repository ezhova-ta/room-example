package com.example.room.db.converters

import androidx.room.TypeConverter
import java.util.*

object DateTimestampConverter {
    @JvmStatic
    @TypeConverter
    fun dateToString(date: Date): Long {
        return date.time
    }

    @JvmStatic
    @TypeConverter
    fun timestampToDate(timestamp: Long): Date {
        return Date(timestamp)
    }
}