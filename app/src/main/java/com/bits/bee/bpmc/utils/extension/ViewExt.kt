package com.bits.bee.bpmc.utils.extension

import android.view.View

/**
 * Created by aldi on 01/03/22.
 */

fun View.visible(){
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun <T> List<T>.mapButReplace(targetItem: T, newItem: T) = map {
    if (it == targetItem) {
        newItem
    } else {
        it
    }
}

