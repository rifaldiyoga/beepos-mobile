package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BpAcc(
    var id : Int? = null,
    var bpId : Int? = null,
    var crcId: Int? = null,
    var purcTermType: String = "",
    var saleTermType: String = "",
    var isDefault: Boolean = false,
) : Parcelable