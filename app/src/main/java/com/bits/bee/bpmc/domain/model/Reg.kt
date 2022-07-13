package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class Reg (
    var code : String,
    var name: String,
    var value: String,
    var isVisible : Boolean,
    var modulCode : String,
    var validator : String?,
) : Parcelable