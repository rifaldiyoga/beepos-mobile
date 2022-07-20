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

    }

}