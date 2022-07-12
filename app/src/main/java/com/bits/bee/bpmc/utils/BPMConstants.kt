package com.bits.bee.bpmc.utils

import java.math.MathContext
import java.math.RoundingMode




/**
 * Created by aldi on 01/03/22.
 */
interface BPMConstants {
    companion object {
        const val BPM_LIMIT_PAGINATION = 10
        const val BPM_MAX_PAGINATION = 30
        const val BPM_DEFAULT_TYPE_CASH_POSSES = "POSSES"
        const val BPM_DEFAULT_TYPE_CASH_CADJ = "CADJ"
        const val BPM_DEFAULT_TYPE_CASH_CSTR = "CSTR"
        const val BPM_DEFAULT_TYPE_CASH_SALE = "sale"
        const val BPM_DEFAULT_TYPE_CASH_TUNAI = "tunai"
        const val BPM_DEFAULT_TYPE_CASH = "CASH"
        const val BPM_DEFAULT_TYPE_KREDIT = "KREDIT"
        const val BPM_DEFAULT_TYPE_CASH_GOPAY = "GOPAY"
        const val SCREEN_POTRAIT = "Portrait"
        const val SCREEN_LANDSCAPE = "Landscape"
        const val DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSSSSS"
        const val MODE_FOOD_BEVERAGES = "MODE_FOOD_AND_BEVERAGES"
        const val MODE_RETAIL = "MODE_RETAIL"
        const val NOTASETTING_LOGOPATH = "NOTASETTING_LOGOPATH"
        const val INIT_DEFAULT_LOGO = "bpm_logo1"
        val MC_FOUR: MathContext = MathContext(19, RoundingMode.HALF_UP)
    }
}