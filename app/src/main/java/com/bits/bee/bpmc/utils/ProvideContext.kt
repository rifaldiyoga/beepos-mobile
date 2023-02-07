package com.bits.bee.bpmc.utils

import android.content.Context
import javax.inject.Inject

class ProvideContext @Inject constructor(
    private val context: Context
) {
    fun getContext(): Context{
        return context
    }
}