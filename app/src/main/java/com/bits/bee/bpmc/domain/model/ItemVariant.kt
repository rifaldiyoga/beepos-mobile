package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class ItemVariant (
    var id : Int,
    var variantId: Int,
    var itemId : Int,
) : Parcelable