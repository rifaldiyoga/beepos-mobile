package com.bits.bee.bpmc.domain.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.bits.bee.bpmc.data.data_source.local.model.CashierEntity

/**
 * Created by aldi on 25/03/22.
 */
data class Cashier (
    var id : Int,
    var code : String,
    var cashierName: String,
    var branchId : Long,
    var cashBranchId : Int,
    var whId : Long,
    var cashId : Long,
    var isActive : Boolean,
    var status : Boolean,
)