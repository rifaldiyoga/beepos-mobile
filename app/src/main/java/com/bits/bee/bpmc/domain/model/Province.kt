package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.ProvinceEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class Province(
    var code: String,
    var name: String,
    var isActive: Boolean,
): Parcelable