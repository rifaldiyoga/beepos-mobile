package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

/**
 * Created by aldi on 30/06/22.
 */
@Parcelize
data class Crc (
    var id : Int?,
    var code : String,
    var name : String,
    var symbol : String,
    var isDefault : Boolean,
    var excRate : BigDecimal,
    var fisRate : BigDecimal,
    var rateType : String,
    var active : Boolean,
) : Parcelable