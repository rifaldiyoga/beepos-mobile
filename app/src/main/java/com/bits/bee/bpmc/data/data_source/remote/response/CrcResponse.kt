package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

/**
 * Created by aldi on 29/03/22.
 */
@Parcelize
data class CrcResponse (
    @SerializedName("status")
    var status:Boolean = false,
    @SerializedName("message")
    var msg : String = "",
    @SerializedName("data")
    var data : MutableList<CrcModel> = mutableListOf()
): Parcelable {

    @Parcelize
    data class CrcModel(
        var id : Int?,
        @SerializedName("code")
        var code : String,
        @SerializedName("name")
        var name : String,
        @SerializedName("symbol")
        var symbol : String,
        @SerializedName("isdefault")
        var isDefault : Boolean,
        @SerializedName("excrate")
        var excRate : BigDecimal,
        @SerializedName("fisrate")
        var fisRate : BigDecimal,
        @SerializedName("ratetype")
        var rateType : String,
        @SerializedName("active")
        var active : Boolean,
    ) : Parcelable

}