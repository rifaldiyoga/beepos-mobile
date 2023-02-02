package com.bits.bee.bpmc.utils

import java.math.BigDecimal

/**
 * Created by aldi on 10/08/22.
 */
class CalcUtils {

    companion object {

        fun getDiscAmt(discExp : String, subtotal : BigDecimal) : BigDecimal {
            if(discExp.isNotEmpty()) {
                val discList = discExp.split("+")
                var discAmt = BigDecimal.ZERO
                var total = subtotal
                var isEmpty = false
                discList.forEachIndexed { index, s ->
                    if(index > 0 && index < discList.size - 1 && s.isEmpty()){
                        isEmpty = true
                    }
                }
                if(isEmpty)
                    throw Exception("Format yang anda masukkan salah!")

                discList.forEach { exp ->
                    if(exp.isNotEmpty()) {
                        val re = Regex("/[^a-zA-Z ]/g")
                        val discRe = re.replace(exp.removeSymbol(), "")
                        if(discRe.isEmpty())
                            throw Exception("Format yang anda masukkan salah!")
                        val disc = BigDecimal(discRe)
                        if (exp.contains("%")) {
                            if(disc <= BigDecimal(100)) {
                                val discamt = total.multiply(
                                    disc.divide(
                                        BigDecimal(100),
                                        BPMConstants.MC_FOUR
                                    )
                                )
                                discAmt = discAmt.add(discamt)
                            }
                        } else {
                            discAmt = discAmt.add(disc)
                        }
                        total = total.subtract(discAmt)
                    }
                }
                return discAmt
            }
            return BigDecimal.ZERO
        }

    }

}