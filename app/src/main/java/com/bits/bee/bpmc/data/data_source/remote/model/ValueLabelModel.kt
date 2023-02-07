package com.bits.bee.bpmc.data.data_source.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 29/03/22.
 */

@Parcelize
data class ValueLabelModel(
    @SerializedName("value")
    var value : Int = -1,
    @SerializedName("label")
    var label : String = "",
) : Parcelable