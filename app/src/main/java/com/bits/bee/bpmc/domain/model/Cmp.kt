package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bits.bee.bpmc.data.data_source.local.model.CmpEntity
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

/**
 * Created by aldi on 30/06/22.
 */
@Parcelize
data class Cmp (
    var id : Int?,
    var cityCode : String,
    var crcId : Int,
    var name : String,
    var address : String,
    var phone : String,
    var fax : String,
    var zipCode : String,
    var startDate : String,
    var fiscalYear : Int,
    var ownerName : String,
    var ownerTaxRegNo : String,
    var formSerno : String,
    var taxRegNo : String,
    var vatRegNo : String,
    var cossType : String,
) : Parcelable