package com.bits.bee.bpmc.domain.model

import java.util.*

/**
 * Created by aldi on 16/11/22
 */
data class FilterDate (
        var selectedPos : Int = 0,
        var startDate : Long = Calendar.getInstance().timeInMillis,
        var endDate : Long = Calendar.getInstance().timeInMillis,
        var isCustom: Boolean = false
)