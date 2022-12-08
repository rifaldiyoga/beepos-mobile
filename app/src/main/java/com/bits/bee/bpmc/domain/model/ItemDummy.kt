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
    var itemGroupId : Int = -1,
    var itemGroup : String = "",
    var brandId: Int? = -1,
    var price : String = "",
    var picPath : String = "",
    var pid : String = "",
    var unitList : List<UnitDummy> = mutableListOf(),
    var unit : String = ""
) : Parcelable