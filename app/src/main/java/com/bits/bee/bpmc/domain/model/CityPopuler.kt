package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CityPopuler(
    var id: Int? = null,
    var nama_city: String
): Parcelable