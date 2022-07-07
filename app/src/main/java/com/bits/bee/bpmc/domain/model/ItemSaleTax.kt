package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.ItemSaleTaxEntity
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 01/07/22.
 */
@Parcelize
data class ItemSaleTax(
    var id : Int? = null,
    var code: String,
    var calcMtd: String,
    var expr: String,
    var exprNoReg: String,
) : Parcelable