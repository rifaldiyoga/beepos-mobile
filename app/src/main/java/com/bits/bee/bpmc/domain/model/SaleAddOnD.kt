package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 23/08/22.
 */
@Parcelize
data class SaleAddOnD (
    var id : Int = -1,
    var saleAddOnId: SaleAddOn? = null,
    var upSaledId: Saled? = null,
    var saledId: Saled? = null,
) : Parcelable