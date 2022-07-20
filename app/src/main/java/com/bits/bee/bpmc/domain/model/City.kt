package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.bits.bee.bpmc.data.data_source.local.model.CityEntity
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * Created by aldi on 18/05/22.
 */
@Parcelize
data class City (
    var code: String,
    var name : String,
//    var isActive : Boolean,
    var updatedAt : Date,
) : Parcelable