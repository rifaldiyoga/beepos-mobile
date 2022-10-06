package com.bits.bee.bpmc.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.bits.bee.bpmc.R

/**
 * Created by aldi on 02/09/22.
 */
class ImageUtils {

    companion object {

        fun generateFromInitial(context : Context, name1: String): Drawable {
            val generatorCol = ColorGenerator.MATERIAL
            val text = getInitial(name1)

            val color = generatorCol.getColor(name1)

            val font = getFontSize(name1.length)

            val hexColor = String.format("#%06X", 0xFFFFFF and color)
            val txtColor: String = ViewUtils.pickTextColorBasedOnBg(hexColor)

            return TextDrawable.builder()
                .beginConfig()
                .fontSize(font)
                .useFont(ResourcesCompat.getFont(context, R.font.nunito_sans))
                .textColor(Color.parseColor(txtColor))
                .endConfig()
                .buildRect(text.uppercase(), color)
        }


        fun getInitial(title: String): String {
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

        fun getFontSize(length : Int) : Int {
            var font = 92
            if (length == 3) font = 74
            if (length == 4) font = 64
            if (length == 5) font = 54
            return font
        }

    }


}