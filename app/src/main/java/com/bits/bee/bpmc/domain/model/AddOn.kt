package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.AddOnEntity
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class AddOn (
    var id : Int,
    var code : String,
    var name: String,
    var isActive : Boolean,
    var createdAt : Date
) : Parcelable