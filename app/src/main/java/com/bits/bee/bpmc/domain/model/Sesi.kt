package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sesi(
    var date: Long,
    var listPosses: MutableList<Posses>? = null,
    var jmltrans: Int,
    var expand: Boolean = false
): Parcelable