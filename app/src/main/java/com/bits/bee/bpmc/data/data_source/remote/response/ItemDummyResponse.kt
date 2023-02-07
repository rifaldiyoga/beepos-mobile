package com.bits.bee.bpmc.data.data_source.remote.response

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class ItemDummyResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean,
    @SerializedName("data")
    @Expose
    var data: List<Data>,
){

    data class Data (
        @SerializedName("name")
        @Expose
        var name: String,
        @SerializedName("id")
        @Expose
        var id: String,
    )
}