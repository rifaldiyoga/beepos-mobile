package com.bits.bee.bpmc.data.data_source.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class CheckDbResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean,
    @SerializedName("data")
    @Expose
    var data: Boolean,
) {

}