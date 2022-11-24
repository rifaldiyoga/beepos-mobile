package com.bits.bee.bpmc.utils

import com.bits.bee.bpmc.domain.model.Cashier
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Singleton


/**
 * Created by aldi on 10/06/22.
 */
@Singleton
class TrxNoGeneratorUtils {

    companion object {

        private val dateFormat = SimpleDateFormat("yyMMdd", Locale.getDefault())
        private val hourFormat = SimpleDateFormat("HH", Locale.getDefault())
        private val minuteFormat = SimpleDateFormat("mm", Locale.getDefault())

        fun generatePossesTrxNo(mCounterShift : Int, mCashier: Cashier) : String {
            val trxNo: String

            val dateNow = Date()
            val timeNow = Calendar.getInstance().time

            trxNo = ("PS/" + String.format("%03d", mCashier.id)
                    + dateFormat.format(dateNow) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                    + "/" + String.format("%03d", mCounterShift))

            return trxNo
        }


        fun counterNoTrx(mCounterNoTrx : Int, cashier: Cashier): String {
            val noTrx: String

            val timeNow = Calendar.getInstance().time
            noTrx = ("JL/" + String.format("%03d",cashier.id)
                    + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(Calendar.getInstance().time).toString()
                    + "/" + String.format("%03d",mCounterNoTrx))
            return noTrx
        }


        fun counterNoTrxCadj(id_cashA: Long, cashier: Cashier): String {
            val noTrx: String
            val mCounterNoTrxCadj = id_cashA.toInt()

            val timeNow = Calendar.getInstance().time
            noTrx = ("CD/" + String.format("%03d",cashier.id)
                    + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                    + "/" + String.format("%03d",mCounterNoTrxCadj))
            return noTrx
        }

        fun counterNoTrxCstr(id_cstr: Int, cashier: Cashier): String {
            val noTrx: String

            val timeNow = Calendar.getInstance().time

            noTrx = ("CT/" + String.format("%03d",cashier.id)
                    + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                    + "/" + String.format("%03d",id_cstr))

            return noTrx
        }

    }

}