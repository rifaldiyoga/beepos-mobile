package com.bits.bee.bpmc.utils

import com.bits.bee.bpmc.domain.model.FilterDate
import java.util.*

/**
 * Created by aldi on 16/11/22
 */
class FilterUtils {

    companion object {

        fun getFilterDate(filter : Int, custDate: String) : FilterDate {
            val startDate = Calendar.getInstance()
            val endDate = Calendar.getInstance()

            if (filter == 0) {
                startDate.add(Calendar.DAY_OF_MONTH, -6)
            }else if (filter == 1) {
                startDate.add(Calendar.MONTH, -1)
            }else if (filter == 2){
                startDate.add(Calendar.MONTH, -3)
            }else if (filter == 3){
                val rangeDate = custDate.split(" - ").toTypedArray()
                val startRange = rangeDate[0]
                val endRange = rangeDate[1]
                val startDateRange = DateFormatUtils.formatStringToDate(BPMConstants.NEW_DATE_FORMAT, startRange)
                val endDateRange = DateFormatUtils.formatStringToDate(BPMConstants.NEW_DATE_FORMAT, endRange)
                startDate.timeInMillis = DateFormatUtils.convertStartDate(startDateRange.time)
                endDate.timeInMillis = DateFormatUtils.convertEndDate(endDateRange.time)
            }

            return FilterDate(selectedPos = filter, startDate =  startDate.timeInMillis, endDate = endDate.timeInMillis)
        }

        fun getFilterDateLabel(filter: Int) : String {
            val list = listOf("1 Minggu Terakhir",
                "1 Bulan Terakhir",
                "90 Hari Terakhir",
                "Custom")
            return list[filter]
        }


    }

}