package com.bits.bee.bpmc.utils

import java.math.MathContext
import java.math.RoundingMode

/**
 * Created by aldi on 01/03/22.
 */
interface BPMConstants {
    companion object {
        const val BPM_DEFAULT_TYPE_POSSES = "POSSES"
        const val BPM_DEFAULT_TYPE_SALE = "SALE"
        const val BPM_DEFAULT_TYPE_CASH = "CASH"
        const val BPM_DEFAULT_TYPE_CADJ = "CADJ"
        const val BPM_DEFAULT_TYPE_CSTR = "CADJ"
        const val BPM_DEFAULT_TYPE_TUNAI = "TUNAI"
        const val BPM_DEFAULT_TYPE_CHG = "CHG"
        const val BPM_DEFAULT_TYPE_DEBIT = "DC"
        const val BPM_DEFAULT_TYPE_KREDIT = "CC"
        const val CADJ = "CADJ"
        const val SALE = "SALE"
        const val BPM_LIMIT_PAGINATION = 10
        const val BPM_MAX_PAGINATION = 30
        const val BPM_DEFAULT_TYPE_CASH_POSSES = "POSSES"
        const val CREDIT_CARD_CODE = "CC"
        const val DEBIT_CARD_CODE = "DC"
        const val BPM_DEFAULT_TYPE_CASH_GOPAY = "GOPAY"
        const val SCREEN_POTRAIT = "Portrait"
        const val SCREEN_LANDSCAPE = "Landscape"
        const val DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSSSSS"
        const val DATE_TIME_FROMAT = "yyyy-MM-dd HH:mm:ss"
        const val NEW_DATE_FORMAT = "dd/MM/yyyy"
        const val MODE_FOOD_BEVERAGES = "MODE_FOOD_AND_BEVERAGES"
        const val MODE_RETAIL = "MODE_RETAIL"
        const val NOTASETTING_LOGOPATH = "NOTASETTING_LOGOPATH"
        const val INIT_DEFAULT_LOGO = "bpm_logo1"
        const val API_MY = "http://my.beecloud.id"
        const val DEFAULT_DB_OFFSET: Long = 0
        const val DEFAULT_DB_LIMIT: Long = 17
        const val DEFAULT_DB_UPLOAD: Long = 40
        const val BPM_DEFAULT_LICENSE_TYPE = "MOBILE"
        const val REGEX_INPUT = "[().,*#!?/|:;'<>@$%&^=+-]"
        const val DIVIDE_DIALOG_SIZE = 2.0
        const val REG_ROUND = "ROUND"
        const val REG_SALE_TAXED = "SALE_TAXED"
        const val REG_SALE_TAXINC = "SALE_TAXINC"
        const val REG_POSSES_ACTUAL_ENDCASH = "POSSES_ACTUAL_ENDCASH"
        const val REG_POS_CARDNO_REQUIRED = "POS_CARDNO_REQUIRED"
        const val REG_POS_TRACKNO_REQUIRED = "POS_TRACKNO_REQUIRED"
        const val REG_ROUND_DIGITS = "ROUND_DIGITS"
        const val REG_ROUND_DIGITS_ENB = "ROUND_DIGITS_ENB"
        const val REG_ROUND_DOWN_BLW = "ROUND_DOWN_BLW"
        val MC_FOUR: MathContext = MathContext(19, RoundingMode.HALF_UP)
    }
}