package com.bits.bee.bpmc.domain.report

import com.bits.bee.bpmc.utils.BPMConstants


/**
 * Created by aldi on 03/11/22
 */
class ReportHelper {

    companion object {
		fun cutString(inputs: String, maxChar: Int): String {
			var s: String = ""
			val split = inputs.split("\n".toRegex()).toTypedArray()
			for (j in split.indices) {
				val input = split[j]
				val stringLong = input.length
				var batasAwal = 0
				var batasAkhir = maxChar - 1
				val divideHeaderLong = stringLong / maxChar + 1
				if (stringLong > 0) {
					for (i in 1..divideHeaderLong) {
						s += input.substring(
							batasAwal,
							if (divideHeaderLong != i) batasAkhir else input.length
						) + BPMConstants.CHAR_ENTER
						batasAwal = batasAkhir
						batasAkhir = batasAwal + maxChar - 1
					}
				} else {
					s += BPMConstants.CHAR_ENTER
				}
			}
			return s
		}

		fun centerString(input: String, maxChar: Int): String {
			var returnString = ""
			val split = input.split("\n".toRegex()).toTypedArray()
			val returnStringBuilder = arrayOfNulls<StringBuilder>(split.size)
			val center = maxChar / 2
			for (i in split.indices) {
				returnStringBuilder[i] = StringBuilder()
				for (j in 0 until maxChar) {
					returnStringBuilder[i]!!.append(" ")
				}
				val startWrite = center - split[i].length / 2
				val endWrite = startWrite + split[i].length
				if (split[i].length < maxChar) {
					returnStringBuilder[i]!!.replace(startWrite, endWrite, split[i])
				} else {
					val replaced = split[i].substring(0, maxChar)
					returnStringBuilder[i]!!.replace(0, returnStringBuilder.size, replaced)
				}
				returnString += returnStringBuilder[i]
			}
			return returnString
		}

		fun generateLine(symbol: String?, maxChar: Int): String {
			val sb = StringBuilder()
			for (i in 0 until maxChar) {
				sb.append(symbol)
			}
			sb.append("\n")
			return sb.toString()
		}

		fun generateTab(
			boundLeft: String,
			boundRight: String,
			tabStyle: Int,
			maxChar: Int
		): String {
			val sbTab = StringBuilder()
			val sizeBound = boundLeft.length + tabStyle
			val sizeGap = boundRight.length + tabStyle
			val sizeTab = maxChar - (sizeBound + sizeGap)
			for (i in 0..sizeTab) {
				sbTab.append(BPMConstants.CHAR_SPACE)
			}
			return sbTab.toString()
		}

		fun generateSpace(spaceSize: Int): String {
			val sbSpace = StringBuilder()
			for (i in 0..spaceSize) {
				sbSpace.append(BPMConstants.CHAR_SPACE)
			}
			return sbSpace.toString()
		}

		fun generateLineCustom(symbol: String?, size: Int): String {
			val sb = StringBuilder()
			for (i in 0 until size) {
				sb.append(symbol)
			}
			return sb.toString()
		}
    }

}