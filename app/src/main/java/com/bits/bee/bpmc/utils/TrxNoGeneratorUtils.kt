package com.bits.bee.bpmc.utils

import android.content.Context
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import dagger.hilt.android.qualifiers.ApplicationContext
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by aldi on 10/06/22.
 */
@Singleton
class TrxNoGeneratorUtils @Inject constructor(
    @ApplicationContext context: Context
){

    companion object {

        fun generatePossesTrxNo(mCounterShift : Int) : String {
            var trxNo = ""
            var branch : Branch = Branch()
            var cashier : Cashier = Cashier()
            val dateFormat = SimpleDateFormat("yyMMdd", Locale.getDefault())
            val hourFormat = SimpleDateFormat("HH", Locale.getDefault())
            val minuteFormat = SimpleDateFormat("mm", Locale.getDefault())

            val dateNow = Date()
            val timeNow = Calendar.getInstance().time

            if (cashier.id >= 10 && mCounterShift >= 10) {
                trxNo = ("PS/" + branch.code + cashier.cashId
                        + dateFormat.format(dateNow) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "0" + mCounterShift)
            } else if (cashier.id >= 10 && mCounterShift >= 100) {
                trxNo = ("PS/" + branch.code + cashier.id
                        + dateFormat.format(dateNow) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "" + mCounterShift)
            } else if (cashier.id >= 10 && mCounterShift >= 1000) {
                trxNo = ("PS/" + branch.code + cashier.id
                        + dateFormat.format(dateNow) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + mCounterShift)
            } else if (cashier.id >= 10 && mCounterShift < 10) {
                trxNo = ("PS/" + branch.code + cashier.id
                        + dateFormat.format(dateNow) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "00" + mCounterShift)
            } else if (cashier.id < 10 && mCounterShift < 10) {
                trxNo = ("PS/" + branch.code + "0" + cashier.id
                        + dateFormat.format(dateNow) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "00" + mCounterShift)
            } else if (cashier.id < 10 && mCounterShift >= 10) {
                trxNo = ("PS/" + branch.code + "0" + cashier.id
                        + dateFormat.format(dateNow) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "0" + mCounterShift)
            } else if (cashier.id < 10 && mCounterShift >= 100) {
                trxNo = ("PS/" + branch.code + "0" + cashier.id
                        + dateFormat.format(dateNow) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "" + mCounterShift)
            } else if (cashier.id < 10 && mCounterShift >= 1000) {
                trxNo = ("PS/" + branch.code + "0" + cashier.id
                        + dateFormat.format(dateNow) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + mCounterShift)
            }
            return trxNo
        }

    }

}