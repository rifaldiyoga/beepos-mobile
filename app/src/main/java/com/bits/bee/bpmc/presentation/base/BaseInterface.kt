package com.bits.bee.bpmc.presentation.base

import android.view.Menu

/**
 * Created by aldi on 28/03/22.
 */
interface BaseInterface {

    fun initComponents()

    fun subscribeListeners()

    fun subscribeObservers()

    fun showSnackbar(msg : String)
}