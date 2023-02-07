package com.bits.bee.bpmc.utils

/**
 * Created by aldi on 12/05/22.
 */
class ViewUtils {

    companion object {
        fun pickTextColorBasedOnBg(bgColor: String): String {
            val color = if (bgColor[0] == '#') bgColor.substring(1, 7) else bgColor
            val r = color.substring(0, 2).toInt(16) // hexToR
            val g = color.substring(2, 4).toInt(16) // hexToG
            val b = color.substring(4, 6).toInt(16) // hexToB
            return if (r * 0.299 + g * 0.587 + b * 0.114 > 186) "#000000" else "#FFFFFF"
        }
    }
}