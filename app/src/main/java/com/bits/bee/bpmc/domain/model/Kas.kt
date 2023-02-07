package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Kas(
    var date: Long,
    var listCadj: MutableList<Cadj>? = null,
    var jmltrans: Int,
): Parcelable