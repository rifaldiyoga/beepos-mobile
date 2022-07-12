package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class ItemBranch (
    var id : Int,
    var branchId: Int,
    var itemId: Int,
) : Parcelable