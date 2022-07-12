package com.bits.bee.bpmc.data.data_source.remote.response

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class StockResponse {
    @SerializedName("status")
    @Expose
    private val status: Boolean? = null

    @SerializedName("data")
    @Expose
    private val data: List<Datum>? = null

    inner class Datum
}