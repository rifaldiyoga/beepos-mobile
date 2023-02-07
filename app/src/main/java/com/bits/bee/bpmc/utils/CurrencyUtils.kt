package com.bits.bee.bpmc.utils

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

/**
 * Created by aldi on 12/05/22.
 */
class CurrencyUtils {

    companion object {

        fun formatCurrency(value : BigDecimal?) : String {
            val format = NumberFormat.getNumberInstance(Locale.getDefault())
            return if(value != null) format.format(value) else "0"
        }

    }

}