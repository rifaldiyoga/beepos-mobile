package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.WhEntity
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 15/07/22.
 */
@Parcelize
data class Wh(
    var id : Int,
    var code : String,
    var name: String,
    var active: Boolean,
) : Parcelable