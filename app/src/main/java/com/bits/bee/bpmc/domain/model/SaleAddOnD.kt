package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 23/08/22.
 */
@Parcelize
data class SaleAddOnD (
    var id : Int? = null,
    var saleAddOn: SaleAddOn? = null,
    var upSaled: Saled? = null,
    var saled: Saled? = null,
) : Parcelable