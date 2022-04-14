package com.bits.bee.bpmc.presentation.custom

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputConnection
import android.widget.Button
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.bits.bee.bpmc.R

/**
 * Created by aldi on 24/03/22.
 */
class CustomNumpadPayment : ConstraintLayout, View.OnClickListener {

    private lateinit var button1 :Button
    private lateinit var button2 :Button
    private lateinit var button3 :Button
    private lateinit var button4 :Button
    private lateinit var button5 :Button
    private lateinit var button6 :Button
    private lateinit var button7 :Button
    private lateinit var button8 :Button
    private lateinit var button9 :Button
    private lateinit var button0 :Button
    private lateinit var button00 :Button
    private lateinit var buttonDelete :ImageButton

    private var keyValues : SparseArray<String> = SparseArray()
    private var mInputConnection : InputConnection? = null

    constructor(context : Context) : super(context, null, 0){
        init(context)
    }

    constructor(context: Context, attrs : AttributeSet) : super(context, attrs, 0){
        init(context, attrs)
    }

    constructor(context : Context, attrs : AttributeSet, defStyleAttr : Int) : super(context, attrs, defStyleAttr){
        init(context, attrs)
    }

    private fun init(context: Context) {
        init(context, null)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        LayoutInflater.from(context).inflate(R.layout.layout_numpad_payment, this, true)

        button1 = findViewById(R.id.numpad_btn1)
        button1.setOnClickListener(this)
        button2 = findViewById(R.id.numpad_btn2)
        button2.setOnClickListener(this)
        button3 = findViewById(R.id.numpad_btn3)
        button3.setOnClickListener(this)
        button4 = findViewById(R.id.numpad_btn4)
        button4.setOnClickListener(this)
        button5 = findViewById(R.id.numpad_btn5)
        button5.setOnClickListener(this)
        button6 = findViewById(R.id.numpad_btn6)
        button6.setOnClickListener(this)
        button7 = findViewById(R.id.numpad_btn7)
        button7.setOnClickListener(this)
        button8 = findViewById(R.id.numpad_btn8)
        button8.setOnClickListener(this)
        button9 = findViewById(R.id.numpad_btn9)
        button9.setOnClickListener(this)
        button0 = findViewById(R.id.numpad_btn0)
        button0.setOnClickListener(this)
        button00 = findViewById(R.id.numpad_btn00)
        button00.setOnClickListener(this)
        buttonDelete = findViewById(R.id.numpad_btnDelete)
        buttonDelete.setOnClickListener(this)

        keyValues.put(R.id.numpad_btn1, "1")
        keyValues.put(R.id.numpad_btn2, "2")
        keyValues.put(R.id.numpad_btn3, "3")
        keyValues.put(R.id.numpad_btn4, "4")
        keyValues.put(R.id.numpad_btn5, "5")
        keyValues.put(R.id.numpad_btn6, "6")
        keyValues.put(R.id.numpad_btn7, "7")
        keyValues.put(R.id.numpad_btn8, "8")
        keyValues.put(R.id.numpad_btn9, "9")
        keyValues.put(R.id.numpad_btn0, "0")
        keyValues.put(R.id.numpad_btn00, "00")
    }

    fun setInputConnection(inputConnection: InputConnection) {
        mInputConnection = inputConnection
    }

    override fun onClick(view: View?) {
        view?.let { v ->
            mInputConnection?.let { ic ->
                if (v.id == R.id.numpad_btnDelete) {
                    ic.performContextMenuAction(android.R.id.selectAll)
                    val selectedText : CharSequence? = ic.getSelectedText(0)

                    selectedText?.let {
                        if (TextUtils.isEmpty(selectedText)) {
                            ic.deleteSurroundingText(1, 0)
                        } else {
                            val text = selectedText.substring(0, selectedText.length - 1)
                            ic.commitText(text, 1)
                        }
                    }
                } else {
                    val value : String = keyValues.get(v.id)
                    ic.commitText(value, 1)
                }
            }
        }

    }
}