package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.EdcSurcEntity
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class EdcSurc (
    var id : Int,
    var edcSurcNo : String,
    var edcId: Int,
    var ccType : String,
    var ccTypeDesc : String,
    var surcExp : String,
    var mdrExp : String,
    var surcAccId : Int,
    var mdrAccId : Int,
    var edcSurcType : String,
    var active : Boolean,
) : Parcelable