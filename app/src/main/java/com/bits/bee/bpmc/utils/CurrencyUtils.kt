package com.bits.bee.bpmc.utils

import java.math.BigDecimal
import java.text.DecimalFormat

/**
 * Created by aldi on 12/05/22.
 */
class CurrencyUtils {

    companion object {

        fun formatCurrency(value : BigDecimal?) : String {
            val format  = DecimalFormat("#,###.##")
            return if(value != null) format.format(value) else "0"
        }

    }

}