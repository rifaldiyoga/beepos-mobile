package com.bits.bee.bpmc.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by aldi on 23/03/22.
 */
class DateFormatUtils  {

    companion object{

        fun formatStringToDate(format : String, value : String?) : Date {
            val sFormat = SimpleDateFormat(format, Locale.getDefault())
            return value?.let { sFormat.parse(it) } ?: Date()
        }

        fun formatDateToString(format: String, value: Date): String{
            val sFormat = SimpleDateFormat(format)
            return sFormat.format(value)
        }

        fun formatDateToLong(format: String, value: Date): Long{
            val sFormat = SimpleDateFormat(format)
            val str = sFormat.format(value)
            val long = sFormat.parse(str).time
            return long
        }

        fun convertStartDate(date: Long): Long{
            val sdate = Date(date)
            val calendar = Calendar.getInstance()
            calendar.time = sdate
            calendar[Calendar.HOUR_OF_DAY] = 0
            calendar[Calendar.MINUTE] = 0
            calendar[Calendar.SECOND] = 0
            return calendar.timeInMillis
        }

        fun convertEndDate(date: Long): Long{
            val edate = Date(date)
            val calendar = Calendar.getInstance()
            calendar.time = edate
            calendar[Calendar.HOUR_OF_DAY] = 23
            calendar[Calendar.MINUTE] = 59
            calendar[Calendar.SECOND] = 59
            return calendar.timeInMillis
        }

    }

}