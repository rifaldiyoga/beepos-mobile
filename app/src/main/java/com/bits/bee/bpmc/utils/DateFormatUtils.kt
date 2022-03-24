package com.bits.bee.bpmc.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by aldi on 23/03/22.
 */
class DateFormatUtils  {

    companion object{

        fun formatStringToDate(format : String, value : String) : Date {
            val sFormat = SimpleDateFormat(format, Locale.getDefault())
            return sFormat.parse(value) ?: Date()
        }

    }

}