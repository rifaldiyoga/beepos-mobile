package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sesi(
    var listPosses: List<Posses>?,
    var date: String,
    var jml_trans: String,
    var expand: Boolean = false
): Parcelable