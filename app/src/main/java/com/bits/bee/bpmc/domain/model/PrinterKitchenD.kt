package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PrinterKitchenD(
    var id : Int? = null,
    var printerKitchenId: Int,
    var kitchenId: Int
) : Parcelable