package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk

import android.content.Context
import android.widget.ArrayAdapter

/**
 * Created by aldi on 28/10/22
 */
class SpinnerAdapter(context : Context, list : List<String>) : ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, list) {

    override fun isEnabled(position: Int): Boolean {
        return position != 0
    }
}