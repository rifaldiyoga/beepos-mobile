package com.bits.bee.bpmc.utils

import android.graphics.Color
import android.graphics.drawable.Drawable
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator

/**
 * Created by aldi on 02/09/22.
 */
class ImageUtils {

    companion object {

        fun generateFromInitial(name1: String): Drawable {
            val generatorCol = ColorGenerator.MATERIAL
            val text = getInitial(name1)

            val color = generatorCol.getColor(name1)

            var font = 92
            if (text.length == 4) font = 64
            if (text.length == 5) font = 54

            val hexColor = String.format("#%06X", 0xFFFFFF and color)
            val txtColor: String = ViewUtils.pickTextColorBasedOnBg(hexColor)

            return TextDrawable.builder()
                .beginConfig()
                .fontSize(font)
                .textColor(Color.parseColor(txtColor))
                .endConfig()
                .buildRect(text.uppercase(), color)
        }


        private fun getInitial(title: String): String {
            val lists = title.split(" ").toTypedArray()
            val list: MutableList<String> = ArrayList()
            for (s in lists) {
                if (s.isNotEmpty()) {
                    list.add(s)
                }
            }
            return when {
                list.size == 1 -> {
                    list[0][0].toString()
                }
                list.size == 2 -> {
                    list[0][0].toString() + list[1][0]
                }
                list.size >= 3 -> {
                    list[0][0].toString() + list[1][0] + list[2][0]
                }
                else -> "I"
            }
        }

    }


}