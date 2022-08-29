package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 23/08/22.
 */
@Parcelize
data class SaleAddOn(
    var id : Int = -1,
    var saleId: Sale? = null,
) : Parcelable