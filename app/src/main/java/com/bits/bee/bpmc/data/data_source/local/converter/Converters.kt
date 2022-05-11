package com.bits.bee.bpmc.data.data_source.local.converter

import androidx.room.TypeConverter
import java.math.BigDecimal
import java.util.*

class Converters {

    @TypeConverter
    fun stringToBigDecimal(value : String?) : BigDecimal? {
        return value?.let { BigDecimal(it) }
    }

    @TypeConverter
    fun bigDecimalToString(value : BigDecimal?) : String? {
        return value?.toString()
    }

    @TypeConverter
    fun longToDate(value : Long?) : Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToLong(value : Date?) : Long? {
        return value?.time
    }

}