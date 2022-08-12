package com.bits.bee.bpmc.data.data_source.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

/**
 * Created by aldi on 05/08/22.
 */
@Parcelize
data class UnitModel(
    @SerializedName("id")
    var id : Int,
    @SerializedName("item_id")
    var itemId : Int,
    @SerializedName("idx")
    var idx: Int,
    @SerializedName("unit")
    var unit: String,
    @SerializedName("conv")
    var conv : BigDecimal,
) : Parcelable