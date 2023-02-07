package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.SelectionEntity
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class Selection (
    var id : Int,
    var code : String,
    var name: String,
    var note: String,
    var isActive : Boolean,
    var isMultiSelect : Boolean,
    var isMultiQty : Boolean,
) : Parcelable