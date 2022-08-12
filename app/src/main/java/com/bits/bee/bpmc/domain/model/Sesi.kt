package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Sesi(
    var listPosses: List<Posses>?,
    var date: Date,
    var jml_trans: String,
    var expand: Boolean = false
): Parcelable