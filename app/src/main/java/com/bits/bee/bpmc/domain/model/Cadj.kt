package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bits.bee.bpmc.data.data_source.local.model.CadjEntity
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal
import java.util.*

/**
 * Created by aldi on 30/06/22.
 */
@Parcelize
data class Cadj (
    var id : Int?,
    var trxDate : Long,
    var amount: BigDecimal,
    var note : String,
    var status: Boolean,
    var refType : String,
    var autoGen : String,
    var cashAId: Int,
    var operatorId: Int,
    var cashierId: Int,
    var isUploaded: Boolean,
    var kodeCadj : String,
    var refNo : String,
    var createdAt: Date = Date(),
    var createdBy: Int = -1,
    var updatedAt: Date = Date(),
    var updatedBy: Int = -1,
) : Parcelable