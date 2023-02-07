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
    var id : Int = -1,
    var code : String = "",
    var cashierName: String = "",
    var branchId : Long = -1,
    var cashBranchId : Int = -1,
    var whId : Long = -1,
    var cashId : Long = -1,
    var isActive : Boolean = false,
    var status : Boolean = false,
) : Parcelable