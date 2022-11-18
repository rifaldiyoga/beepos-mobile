package com.bits.bee.bpmc.data.data_source.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 13/07/22.
 */

@Parcelize
data class BpAccModel (
    @SerializedName("bp_id")
    var bp_id : Int,
    @SerializedName("crc_id")
    var crc_id: Int,
    @SerializedName("isdefault")
    var isdefault: Boolean,
    @SerializedName("purctermtype")
    var purcTermType: String,
    @SerializedName("saletermtype")
    var saleTermType: String,
) : Parcelable