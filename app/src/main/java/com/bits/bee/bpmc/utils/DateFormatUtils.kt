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

        fun formatLongToString(format: String, value: Long): String{
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

            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            return calendar.timeInMillis
        }

        fun convertEndDate(date: Long): Long{
            val edate = Date(date)
            val calendar = Calendar.getInstance()
            calendar.time = edate

            calendar.set(Calendar.HOUR_OF_DAY, 23)
            calendar.set(Calendar.MINUTE, 59)
            calendar.set(Calendar.SECOND, 59)
            return calendar.timeInMillis
        }

        fun convertLongToTime(formats: String, time: Long): String {
            val date = Date(time)
            val sformat = SimpleDateFormat(
                formats,
                Locale.getDefault())
            return sformat.format(date)
        }

    }

}