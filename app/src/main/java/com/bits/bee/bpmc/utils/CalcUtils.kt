package com.bits.bee.bpmc.utils

import com.bits.bee.bpmc.utils.extension.removeSymbol
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

                for (exp in discList) {
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
                    } else {
                        throw Exception("Format yang anda masukkan salah!")
                    }
                }
                return discAmt
            }
            return BigDecimal.ZERO
        }

    }

}