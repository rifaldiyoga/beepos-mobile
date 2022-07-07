package com.bits.bee.bpmc.domain.model

import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.KitchenEntity

data class Kitchen(
    var id : Int,
    var code : String? = null,
    var name: String,
    var branchId: Int = 0,
    var createdBy : Int = 0,
    var createdAt : Long = 0,
    var updatedBy : Int = 0,
    var updatedAt : Long = 0,
    var isUsed : Boolean = false,
)