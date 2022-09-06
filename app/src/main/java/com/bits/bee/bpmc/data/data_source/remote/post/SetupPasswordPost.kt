package com.bits.bee.bpmc.data.data_source.remote.post

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class SetupPasswordPost (
    @SerializedName("status")
    @Expose
    var status: Boolean,
    @SerializedName("myauthkey")
    @Expose
    var myauthkey: String,
    @SerializedName("password")
    @Expose
    var password: String,
    @SerializedName("pin")
    @Expose
    var pin: String,
)