package com.bits.bee.bpmc.presentation.ui.walkthrough

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 09/12/22
 */
@Parcelize
data class WalkThrough(
    val image : Int,
    val title : Int,
    val desc : Int
) : Parcelable