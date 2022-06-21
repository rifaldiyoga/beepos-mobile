package com.bits.bee.bpmc.data.calc

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.utils.BPMConstants
import java.math.BigDecimal
import java.math.RoundingMode


/**
 * Created by aldi on 19/05/22.
 */
class SaleCalc {
    companion object{

        fun calculate(sale: Sale, saledList: List<Saled>, bp: Bp) {
            calculateSubtotal(sale, saledList, bp)
        }

        private fun calculateSubtotal(sale: Sale, saledList: List<Saled>, bp : Bp) {
            var roundVal = 0
            var roundBelow = 0
            var roundDigits = "0"
            var isRoundEnable = false

//        val reg: Reg = RegDao.getInstance().readByCode(BPMConstants.REG_ROUND)
//        val regDigits: Reg = RegDao.getInstance().readByCode(BPMConstants.REG_ROUND_DIGITS)
//        val regEnable: Reg = RegDao.getInstance().readByCode(BPMConstants.REG_ROUND_DIGITS_ENB)
//        val regBelow: Reg = RegDao.getInstance().readByCode(BPMConstants.REG_ROUND_DOWN_BLW)
//        roundVal = if (!reg.value.isEmpty()) reg.value.toInt() else 0
//        isRoundEnable =
//            if (!regEnable.value.isEmpty()) regEnable.value == "1" else false
//        roundBelow =
//            if (!regBelow.value.isEmpty()) regBelow.value.toInt() else 0
//        roundDigits =
//            if (!regDigits.value.isEmpty()) regDigits.value else "0"

            sale.subtotal = BigDecimal.ZERO
            sale.taxAmt = BigDecimal.ZERO
            sale.total = BigDecimal.ZERO
            for (i in saledList) {
                val saled = i
                val nettprice: BigDecimal =
                    saled.listPrice.subtract(saled.discAmt, BPMConstants.MC_FOUR)
                if (bp.isTaxIncOnSale) {
                    val numetor: BigDecimal = BigDecimal(100).add(saled.tax)
                    val denominator = BigDecimal(100)
                    saled.basePrice =
                        saled.discAmt.add(
                            nettprice.multiply(denominator, BPMConstants.MC_FOUR)
                                .divide(numetor, BPMConstants.MC_FOUR), BPMConstants.MC_FOUR
                        )

                } else {
                    saled.basePrice = saled.listPrice.setScale(roundVal, RoundingMode.HALF_UP)
                }
                saled.subtotal = saled.basePrice.subtract(saled.discAmt, BPMConstants.MC_FOUR)
                    .multiply(saled.qty, BPMConstants.MC_FOUR)
                saled.totalDiscAmt = saled.discAmt.multiply(saled.qty, BPMConstants.MC_FOUR)
                saled.totalDisc2Amt = saled.disc2Amt.multiply(saled.qty, BPMConstants.MC_FOUR)
                saled.taxableAmt =
                    nettprice.subtract(saled.disc2Amt, BPMConstants.MC_FOUR)
                        .multiply(saled.qty, BPMConstants.MC_FOUR)
                saled.totalTaxAmt = saled.taxAmt.multiply(saled.qty, BPMConstants.MC_FOUR)
                if (bp.isTaxIncOnSale) {
                    val numetor: BigDecimal = BigDecimal(100).add(saled.tax, BPMConstants.MC_FOUR)
                    val denominator = BigDecimal(100)
                    saled.taxableAmt =
                        nettprice.multiply(saled.qty, BPMConstants.MC_FOUR)
                            .divide(numetor, BPMConstants.MC_FOUR)
                            .multiply(denominator, BPMConstants.MC_FOUR)
                            .subtract(saled.totalDisc2Amt, BPMConstants.MC_FOUR)

                } else {
                    saled.taxableAmt =
                        nettprice.multiply(saled.qty, BPMConstants.MC_FOUR)
                            .subtract(saled.totalDisc2Amt, BPMConstants.MC_FOUR)
                }
                if (bp.isTaxedOnSale) {
                    saled.totalTaxAmt  =
                        saled.taxableAmt.multiply(saled.tax, BPMConstants.MC_FOUR)
                            .divide(BigDecimal(100), BPMConstants.MC_FOUR)
                    saled.taxAmt =
                        saled.totalTaxAmt.divide(saled.qty, BPMConstants.MC_FOUR)
                            .setScale(roundVal, RoundingMode.HALF_UP)
                } else {
                    saled.totalTaxAmt  = BigDecimal.ZERO
                    saled.taxAmt = BigDecimal.ZERO
                }
                sale.taxAmt =
                    sale.taxAmt
                        .add(saled.totalTaxAmt.setScale(roundVal, BigDecimal.ROUND_HALF_UP))
                //            sale.setDiscamt(sale.discAmt.add(saled.totalDiscAmt).setScale(roundVal, RoundingMode.HALF_UP));
                sale.subtotal = sale.subtotal.add(saled.subtotal.setScale(roundVal, BigDecimal.ROUND_HALF_UP))
                saled.subtotal = saled.subtotal.setScale(roundVal, RoundingMode.HALF_UP)
                saled.totalDiscAmt = saled.totalDiscAmt.setScale(roundVal, RoundingMode.HALF_UP)
                saled.totalDisc2Amt = saled.totalDisc2Amt.setScale(roundVal, RoundingMode.HALF_UP)
                saled.taxableAmt = saled.taxableAmt.setScale(roundVal, RoundingMode.HALF_UP)
                saled.totalTaxAmt  =saled.totalTaxAmt.setScale(roundVal, RoundingMode.HALF_UP)
                saled.taxableAmt = saled.taxableAmt.setScale(roundVal, RoundingMode.HALF_UP)
                saled.totalTaxAmt  =saled.totalTaxAmt.setScale(roundVal, RoundingMode.HALF_UP)
                saled.taxAmt = saled.taxAmt.setScale(roundVal, RoundingMode.HALF_UP)
            }
            //        sale.taxAmt = sale.taxAmt.setScale(roundVal, RoundingMode.HALF_UP));
//        sale.subtotal = sale.subtotal.setScale(roundVal, RoundingMode.HALF_UP));
            val total: BigDecimal = sale.subtotal.subtract(sale.discAmt, BPMConstants.MC_FOUR)
                .add(sale.taxAmt, BPMConstants.MC_FOUR)
                .setScale(roundVal, RoundingMode.HALF_UP)
            if (isRoundEnable) {
                val round: BigDecimal = roundingTotal(total, roundDigits.length, roundBelow)
                sale.total = round
                sale.rounding = total.subtract(round).multiply(BigDecimal(-1))
            } else {
                sale.total = total
            }
        }

        fun clearCalculate(saledList: MutableList<Saled?>) {
            saledList.clear()
        }

        /**
         * @param total = Total Sale sebelum rounding
         * @param roundDigits
         * @param minRound = Rounding down below
         * @return
         */
        private fun roundingTotal(total: BigDecimal, roundDigits: Int, minRound: Int): BigDecimal {
            var result: BigDecimal
            val roundDecimal: BigDecimal = total.setScale(0, RoundingMode.HALF_UP)
            val totalString: String = roundDecimal.toString()
            val divider = BigDecimal(intToString(roundDigits))

            // get beberapa nilai terakhir dari total sesuai dengan round digits
            val totalValue =
                if (totalString != "0" && totalString.length > roundDigits) totalString.substring(
                    totalString.length - roundDigits
                ).toInt() else 0
            val rest: BigDecimal = total.remainder(divider)
            result = if (totalValue > minRound) {
                total.subtract(rest).add(divider)
            } else {
                total.subtract(rest)
            }
            return result
        }

        private fun intToString(digits: Int): String {
            var output = "1"
            while (output.length <= digits) output += "0"
            return output
        }
    }

}