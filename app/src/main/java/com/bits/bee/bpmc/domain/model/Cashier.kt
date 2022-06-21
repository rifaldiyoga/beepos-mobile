package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.bits.bee.bpmc.data.data_source.local.model.CashierEntity
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 25/03/22.
 */
@Parcelize
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
) : Parcelable