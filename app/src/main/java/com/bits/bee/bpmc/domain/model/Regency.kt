package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class Regency(
    var code: String,
    var name : String,
    var provinceCode : String,
    var isActive : Boolean,
): Parcelable