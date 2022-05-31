package com.bits.bee.bpmc.utils

import java.math.BigDecimal
import java.math.RoundingMode


/**
 * Created by aldi on 25/05/22.
 */
class BSmartPay {

    companion object {

        fun genSmartPay(total: BigDecimal): HashMap<String, String> {
            val returnHash = HashMap<String, String>()
            val totalRounded: String = total.setScale(0, RoundingMode.UP).toString()
            returnHash[total.toString()] = total.toString()
            returnHash[spawnFiftyThousand(totalRounded)] = spawnFiftyThousand(totalRounded)
            returnHash[spawnTwentyThousandFromZero(totalRounded)] = spawnTwentyThousandFromZero(totalRounded)
            returnHash[spawnOneHundredThousand(totalRounded)] = spawnOneHundredThousand(totalRounded)
            returnHash[spawnTwentyThousandFromFifty(totalRounded)] = spawnTwentyThousandFromFifty(totalRounded)
            returnHash[spawnTenThousand(totalRounded)] = spawnTenThousand(totalRounded)
            //		returnHash.put(spawnFiveThousand(total), spawnFiveThousand(total));
//		returnHash.put(spawnOneThousand(total), spawnOneThousand(total));
            return returnHash
        }

        private fun spawnOneHundredThousand(total: String): String {
            if (total.endsWith("00000")) {
                return total
            }
            return if (total.length >= 6) {
                var returnInt = BigDecimal(Character.getNumericValue(total[total.length - 6]))
                returnInt = returnInt.add(BigDecimal.ONE)
                total.replace(
                    total.substring(total.length - 6),
                    returnInt.toString() + "00000"
                )
            } else {
                total.replace(total, "100000")
            }
        }

        private fun spawnFiftyThousand(total: String): String {
            if (total.endsWith("50000") || total.endsWith("00000")) return total
            return if (total.length > 5) {
                val charAtTotMin5 = BigDecimal(Character.getNumericValue(total[total.length - 5]))
                if (charAtTotMin5.compareTo(BigDecimal(5)) == -1) {
                    total.replace(total.substring(total.length - 5), "50000")
                } else {
                    if (total.length >= 6) {
                        var returnInt = BigDecimal(Character.getNumericValue(total[total.length - 6]))
                        returnInt = returnInt.add(BigDecimal.ONE)
                        total.replace(
                            total.substring(total.length - 6),
                            returnInt.toString() + "00000"
                        )
                    } else {
                        total.replace(total.substring(total.length - 6), "100000")
                    }
                }
            } else {
                if (total.length < 5) {
                    total.replace(total, "50000")
                } else {
                    val charAtTotMin5 = BigDecimal(Character.getNumericValue(total[total.length - 5]))
                    if (charAtTotMin5.compareTo(BigDecimal(5)) == -1) {
                        total.replace(total, "50000")
                    } else total.replace(total, "100000")
                }
            }
        }

        private fun spawnTwentyThousandFromZero(total: String): String {
            if (total.length < 5) {
                return "20000"
            }
            if (total.length > 4) {
                val extractedInt =
                    total.substring(total.length - 5).replace("[,.]".toRegex(), "").toInt()
                if (extractedInt % 20000 != 0) {
                    var returnInt = BigDecimal(Character.getNumericValue(total[total.length - 5]))
                    returnInt = returnInt.add(BigDecimal.ONE)
                    return total.replace(
                        total.substring(total.length - 5),
                        returnInt.toString() + "0000"
                    )
                }
            }
            return total
        }

        private fun spawnTwentyThousandFromFifty(total: String): String {
            if (total.length > 4) {
                val extractedInt = BigDecimal("" + total.substring(total.length - 5))
                if (extractedInt.compareTo(BigDecimal(50000)) == 1) {
                    if (extractedInt.compareTo(BigDecimal(70000)) == -1) {
                        return total.replace(total.substring(total.length - 5), "70000")
                    }
                    return if (extractedInt.compareTo(BigDecimal(90000)) == -1) {
                        total.replace(total.substring(total.length - 5), "90000")
                    } else total
                }
            }
            return total
        }

        private fun spawnTenThousand(total: String): String {
            if (total.length > 4) {
                if (total.endsWith("0000")) {
                    return total
                }
                var returnInt = BigDecimal(Character.getNumericValue(total[total.length - 5]))
                returnInt = returnInt.add(BigDecimal.ONE)
                return total.replace(
                    total.substring(total.length - 5),
                    returnInt.toString().toString() + "0000"
                )
            }
            return total.replace(total, "10000")
        }

        private fun spawnFiveThousand(total: String): String? {
            if (total.length < 4) {
                return total.replace(total, "5000")
            }
            var extractedInt = BigDecimal(total.substring(total.length - 4))
            val charAtTotMin4 = BigDecimal("" + total[total.length - 4])
            if (charAtTotMin4.compareTo(BigDecimal(5)) == -1) {
                extractedInt = extractedInt.remainder(BigDecimal(5000))
                if (extractedInt.compareTo(BigDecimal.ZERO) != 0) {
                    return total.replace(total.substring(total.length - 4), "5000")
                }
            }
            return total
        }

        private fun spawnTwoThousand(total: String): String? {
            if (total.endsWith("000")) {
                return total
            }
            if (total.length < 4) {
                return total.replace(total, "2000")
            }
            var returnInt = BigDecimal(total.substring(0, total.length - 3))
            returnInt = returnInt.add(BigDecimal.ONE)
            return total.replace(total, returnInt.toString() + "000")
        }

        private fun spawnOneThousand(total: String): String? {
            if (total.endsWith("000")) {
                return total
            }
            if (total.length < 4) {
                return total.replace(total, "1000")
            }
            var returnInt = BigDecimal(total.substring(0, total.length - 3))
            returnInt = returnInt.add(BigDecimal.ONE)
            return total.replace(total, returnInt.toString() + "000")
        }
    }

}