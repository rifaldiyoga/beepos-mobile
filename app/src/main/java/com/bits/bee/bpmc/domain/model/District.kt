package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class District(
    var code: String,
    var name : String,
    var regencyCode : String,
    var isActive : Boolean,
): Parcelable