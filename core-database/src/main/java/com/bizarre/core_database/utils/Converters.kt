package com.bizarre.core_database.utils

import androidx.room.TypeConverter
import java.time.LocalDateTime

class LocalDateTimeConverter {
    @TypeConverter
    fun toLocalDateTime(date: String): LocalDateTime = LocalDateTime.parse(date)

    @TypeConverter
    fun toDateString(date: LocalDateTime): String = date.toString()
}