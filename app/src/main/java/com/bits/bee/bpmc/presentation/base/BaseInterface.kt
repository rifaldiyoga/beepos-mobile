package com.bits.bee.bpmc.presentation.base

import android.view.Menu
import androidx.annotation.StringRes

/**
 * Created by aldi on 28/03/22.
 */
interface BaseInterface {

    fun initComponents()

    fun subscribeListeners()

    fun subscribeObservers()

    fun showSnackbar(message: String)

    fun showSnackbarWithAction(
        @StringRes message: Int,
        @StringRes actionText: Int,
        action: () -> Any
    )

    fun showToast(@StringRes message: Int)
}