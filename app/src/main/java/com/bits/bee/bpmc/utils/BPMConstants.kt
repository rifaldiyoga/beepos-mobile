package com.bits.bee.bpmc.utils

import android.os.Build
import android.os.Environment
import java.math.MathContext
import java.math.RoundingMode

/**
 * Created by aldi on 01/03/22.
 */
interface BPMConstants {
    companion object {
        const val AWS_KEY = "DZA3URDW4JHRENEH2D5V"
        const val AWS_SECRET = "c2i6w3QR5/nHq2yIkuHDssBKBOtgci/eNsAi+5jUzdI"
        const val BPM_DEFAULT_TYPE_POSSES = "POSSES"
        const val BPM_DEFAULT_TYPE_SALE = "SALE"
        const val BPM_DEFAULT_TYPE_CASH = "CASH"
        const val BPM_DEFAULT_TYPE_CADJ = "CADJ"
        const val BPM_DEFAULT_TYPE_CSTR = "CSTR"
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
        const val DATE_FORMAT_RESPONSE = "yyyy-MM-dd HH:mm:ss.SSSSSS"
        const val DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"
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
        const val REG_PRCLVL_DEFAULT = "PRCLVL_DEFAULT"
        const val REG_CHANNEL_PRICE = "CHANNEL_PRICE"
        const val BPM_PARENTPATH = "/BPM"
        const val BPM_PRODUKPATH = "$BPM_PARENTPATH/PRODUK"

        fun getDatapath(): String{
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                    .toString()
            } else {
                StringBuilder(Environment.getExternalStorageDirectory().absolutePath.toString()).toString()
            }
        }

        const val BPM_TYPE_ROUNDING = "ROUNDING"

        // PRIVILLEGE
        const val PRVSALE = "815005"
        const val PRVSO = "815002"
        const val ACS_ENB = "ENB"
        const val ACS_NEW = "NEW"
        const val ACS_OPN = "OPN"
        const val ACS_UPD = "UPD"
        const val ACS_DEL = "DEL"
        const val ACS_PRN = "PRN"
        const val ACS_DISC = "DISC"
        const val ACS_DISC_MASTER = "DISC_MASTER"
        const val ACS_TAXINC = "TAXINC"
        const val ACS_PRICE_EDIT = "PRICE_EDIT"
        const val BPM_PRIVILEGE_PRICE = "PRICE_EDIT"
        const val BPM_PRIVILEGE_DISC = "DISC"
        const val BPM_PRIVILEGE_DISC_MASTER = "DISC_MASTER"
        const val BPM_PRIVILEGE_OBJ = "845005"

        const val CHAR_ENTER = "\n"
        const val CHAR_SPACE = " "
        const val CHAR_DOUBLE_SPACE = "  "
        const val CHAR_TRIPLE_SPACE = "   "
        const val CHAR_LONG_SPACE = "     "
        const val CHAR_DOUBLE_ENTER = "\n\n"

        const val BPM_TAB_SMALL = 5
        const val BPM_TAB_NORMAL = 3
        const val BPM_TAB_LARGE = 1
        const val BPM_TAB_HEADER_SMALL = 9
        const val BPM_TAB_HEADER_NORMAL_USB = 6
        const val BPM_TAB_HEADER_NORMAL = 7
        const val BPM_TAB_HEADER_LARGE = 5
        const val BPM_TAB_HEADER_LARGE_USB = 3

        const val BPM_FONT_REGULAR = "REGULAR"
        const val BPM_ALIGN_LEFT = "LEFT"
        const val BPM_ALIGN_CENTER = "CENTER"
        const val BPM_ALIGN_RIGHT = "RIGHT"

        const val BPM_DEFAULT_THREAD_TIMEOUT: Long = 100000
        const val BPM_INIT_DEFAULT_LOGO = "logo_bpmc_01"

        const val BPM_PRINTER_BLUETOOH = 0
        const val BPM_PRINTER_WIFI = 1
        const val BPM_PRINTER_USB = 2

        val MC_FOUR: MathContext = MathContext(19, RoundingMode.HALF_UP)

        const val NOTIFICATION_ID = 833
    }
}