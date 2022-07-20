package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.EdcEntity
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class Edc (
    var id : Int,
    var code : String,
    var name : String,
    var cash: Int,
    var note : String,
    var surcPayTo : String?,
    var branchId: Int?,
    var active: Boolean,
) : Parcelable