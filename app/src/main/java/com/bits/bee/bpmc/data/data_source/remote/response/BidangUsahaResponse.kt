package com.bits.bee.bpmc.data.data_source.remote.response

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




/**
 * Created by aldi on 02/09/22.
 */
data class BidangUsahaResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean,
    @SerializedName("data")
    @Expose
    var data: List<Data> = ArrayList()
) {

    data class Data (
        @SerializedName("kategori")
        @Expose
        var kategori: String = "",
        @SerializedName("usaha")
        @Expose
        var dataUsaha: List<DataUsaha> = ArrayList()
    )

    data class DataUsaha (
        @SerializedName("id")
        @Expose
        var id : Int = 0,
        @SerializedName("name")
        @Expose
        var name: String = "",
        @SerializedName("kategori_usaha_id")
        @Expose
        var kategori: String = "",
        @SerializedName("created_at")
        @Expose
        var created_at: String? = null
    )

}