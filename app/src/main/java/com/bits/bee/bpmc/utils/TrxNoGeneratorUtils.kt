package com.bits.bee.bpmc.utils

import android.R
import android.content.Context
import com.bits.bee.bpmc.data.data_source.local.dao.BranchDao
import com.bits.bee.bpmc.data.data_source.local.dao.CashierDao
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
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
    @ApplicationContext context: Context,
    getActiveBranchUseCase: GetActiveBranchUseCase,
    getActiveCashierUseCase: GetActiveCashierUseCase
){

    companion object {

        private val dateFormat = SimpleDateFormat("yyMMdd", Locale.getDefault())
        private val hourFormat = SimpleDateFormat("HH", Locale.getDefault())
        private val minuteFormat = SimpleDateFormat("mm", Locale.getDefault())

        fun generatePossesTrxNo(mCounterShift : Int, mBranch: Branch, mCashier: Cashier) : String {
            var trxNo = ""
            val branch = mBranch
            var cashier = mCashier

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


        fun counterNoTrx(mCounterNoTrx : Int, branch: Branch, cashier: Cashier): String {
             var no_trx = ""

            val timeNow = Calendar.getInstance().time

            if (cashier.id >= 10 && mCounterNoTrx >= 10) {
                no_trx = ("JL/" + branch.code + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(Calendar.getInstance().time).toString()
                        + "/" + "0" + mCounterNoTrx)
            } else if (cashier.id >= 10 && mCounterNoTrx >= 100) {
                no_trx = ("JL/" + branch.code + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(Calendar.getInstance().time) + minuteFormat.format(timeNow).toString()
                        + "/" + "" + mCounterNoTrx)
            } else if (cashier.id >= 10 && mCounterNoTrx >= 1000) {
                no_trx = ("JL/" + branch.code + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + mCounterNoTrx)
            } else if (cashier.id >= 10 && mCounterNoTrx < 10) {
                no_trx = ("JL/" + branch.code + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "00" + mCounterNoTrx)
            } else if (cashier.id < 10 && mCounterNoTrx < 10) {
                no_trx = ("JL/" + branch.code.toString() + "0"
                        + cashier.id + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "00" + mCounterNoTrx)
            } else if (cashier.id < 10 && mCounterNoTrx >= 10) {
                no_trx = ("JL/" + branch.code.toString() + "0" + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "0" + mCounterNoTrx)
            } else if (cashier.id < 10 && mCounterNoTrx >= 100) {
                no_trx = ("JL/" + branch.code.toString() + "0" + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "" + mCounterNoTrx)
            } else if (cashier.id < 10 && mCounterNoTrx >= 1000) {
                no_trx = ("JL/" + branch.code.toString() + "0" + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + mCounterNoTrx)
            }
            return no_trx
//        Toast.makeText(getContext(), ""+no_trx, Toast.LENGTH_SHORT).show();
        }


        fun counterNoTrxCadj(id_cashA: Long, branch: Branch, cashier: Cashier): String? {
            var no_trx = ""
            var mCounterNoTrxCadj = id_cashA.toInt()

            val timeNow = Calendar.getInstance().time

            if (cashier.id >= 10 && mCounterNoTrxCadj >= 10) {
                no_trx = ("CD/" + branch.code + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "0" + mCounterNoTrxCadj)
            } else if (cashier.id >= 10 && mCounterNoTrxCadj >= 100) {
                no_trx = ("CD/" + branch.code + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "" + mCounterNoTrxCadj)
            } else if (cashier.id >= 10 && mCounterNoTrxCadj >= 1000) {
                no_trx = ("CD/" + branch.code + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + mCounterNoTrxCadj)
            } else if (cashier.id >= 10 && mCounterNoTrxCadj < 10) {
                no_trx = ("CD/" + branch.code + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "00" + mCounterNoTrxCadj)
            } else if (cashier.id < 10 && mCounterNoTrxCadj < 10) {
                no_trx = ("CD/" + branch.code.toString() + "0" + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "00" + mCounterNoTrxCadj)
            } else if (cashier.id < 10 && mCounterNoTrxCadj >= 10) {
                no_trx = ("CD/" + branch.code.toString() + "0" + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "0" + mCounterNoTrxCadj)
            } else if (cashier.id < 10 && mCounterNoTrxCadj >= 100) {
                no_trx = ("CD/" + branch.code.toString() + "0" + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "" + mCounterNoTrxCadj)
            } else if (cashier.id < 10 && mCounterNoTrxCadj >= 1000) {
                no_trx = ("CD/" + branch.code.toString() + "0" + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + mCounterNoTrxCadj)
            }
            return no_trx
//        Toast.makeText(getContext(), ""+no_trx, Toast.LENGTH_SHORT).show();
        }

        fun counterNoTrxCstr(id_cstr: Int, branch: Branch, cashier: Cashier): String? {
            var no_trx = ""
            var mCounterNoTrxCstr = id_cstr

            val timeNow = Calendar.getInstance().time

            if (cashier.id >= 10 && mCounterNoTrxCstr >= 10) {
                no_trx = ("CT/" + branch.code + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "0" + mCounterNoTrxCstr)
            } else if (cashier.id >= 10 && mCounterNoTrxCstr >= 100) {
                no_trx = ("CT/" + branch.code + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "" + mCounterNoTrxCstr)
            } else if (cashier.id >= 10 && mCounterNoTrxCstr >= 1000) {
                no_trx = ("CT/" + branch.code + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + mCounterNoTrxCstr)
            } else if (cashier.id >= 10 && mCounterNoTrxCstr < 10) {
                no_trx = ("CT/" + branch.code + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "00" + mCounterNoTrxCstr)
            } else if (cashier.id < 10 && mCounterNoTrxCstr < 10) {
                no_trx = ("CT/" + branch.code.toString() + "0" + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "00" + mCounterNoTrxCstr)
            } else if (cashier.id < 10 && mCounterNoTrxCstr >= 10) {
                no_trx = ("CT/" + branch.code.toString() + "0" + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "0" + mCounterNoTrxCstr)
            } else if (cashier.id < 10 && mCounterNoTrxCstr >= 100) {
                no_trx = ("CT/" + branch.code.toString() + "0" + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + "" + mCounterNoTrxCstr)
            } else if (cashier.id < 10 && mCounterNoTrxCstr >= 1000) {
                no_trx = ("CT/" + branch.code.toString() + "0" + cashier.id
                        + dateFormat.format(Date()) + hourFormat.format(timeNow) + minuteFormat.format(timeNow).toString()
                        + "/" + mCounterNoTrxCstr)
            }
            return no_trx
        }

    }

}