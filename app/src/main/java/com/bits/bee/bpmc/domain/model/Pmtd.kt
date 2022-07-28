package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.PmtdEntity
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class Pmtd (
    var id : Int?,
    var idx : Int?,
    var code : String,
    var name: String,
    var cashId : Int?,
    var mdrExp : String?,
    var mdrAcc : Int,
    var surExp : String?,
    var surAcc : Int,
    var branchId : Int?,
    var settleDays : Int?,
    var cashName : String?,
    var branchName : String?,
    var ccType : String,
    var edcSurcType : String,
) : Parcelable