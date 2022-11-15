package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Brand(
    var id: Int? = null,
    var code: String,
    var brandName: String,
    var active: Boolean
): Parcelable