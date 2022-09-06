package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 10/08/22.
 */
@Parcelize
data class ItemDummy (
    var id : Int? = null,
    var name: String = "",
    var itemTypeCode: String = "",
    var itemGroup : String = "",
    var price : String = "",
    var unit: String = "",
    var picPath : String = "",
    var pid : String = "",
) : Parcelable