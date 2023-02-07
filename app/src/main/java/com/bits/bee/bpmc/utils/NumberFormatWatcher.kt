package com.bits.bee.bpmc.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.text.DecimalFormat
import java.text.ParseException

/**
 * Created by aldi on 18/07/22.
 */
class NumberFormatWatcher(private val editText: EditText) : TextWatcher {

    private val decimalFormat = DecimalFormat("#,###.##")
    private val decimalFormatNoFrac = DecimalFormat("#,###")

    private var hasFractionalPart = false

    init {
        decimalFormat.isDecimalSeparatorAlwaysShown = true
    }

    override fun afterTextChanged(s: Editable?) {
        editText.removeTextChangedListener(this)

        try {
            val initialLength = editText.text.length

            val v = s.toString()
                .replace(decimalFormat.decimalFormatSymbols.groupingSeparator.toString(), "")
            val number = decimalFormat.parse(v)

            val cp = editText.selectionStart
            if (hasFractionalPart) {
                editText.setText(decimalFormat.format(number))
            } else {
                editText.setText(decimalFormatNoFrac.format(number))
            }
            val endLength = editText.length()
            val selection = (cp + (endLength - initialLength))
            if (selection > 0 && selection <= editText.text.length) {
                editText.setSelection(selection)
            } else {
                editText.setSelection(editText.text.length - 1)
            }
        } catch (nfe: NumberFormatException) {

        } catch (ex: ParseException) {

        }

        editText.addTextChangedListener(this)
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        hasFractionalPart =
            s.toString().contains(decimalFormat.decimalFormatSymbols.decimalSeparator)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
}