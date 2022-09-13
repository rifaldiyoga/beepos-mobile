package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


/**
 * Created by aldi on 09/09/22
 */
@Parcelize
data class PromoMultiResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean,
    @SerializedName("data")
    @Expose
    var data: List<DataPromoMulti> = mutableListOf()
) : Parcelable {

    @Parcelize
    data class DataPromoMulti (
        @SerializedName("promo_id")
        @Expose
        var promoid :Int = 0,
        @SerializedName("type")
        @Expose
        var type: String,
        @SerializedName("value")
        @Expose
        var value: String,
        @SerializedName("isreq")
        @Expose
        var isIsreq : Boolean = false,
        @SerializedName("isdeal")
        @Expose
        var isIsdeal : Boolean = false,
    ) : Parcelable

}