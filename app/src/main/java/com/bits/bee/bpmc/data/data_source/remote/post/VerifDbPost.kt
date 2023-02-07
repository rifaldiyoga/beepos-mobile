package com.bits.bee.bpmc.data.data_source.remote.post

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class VerifDbPost (
    @SerializedName("status")
    @Expose
    var status: Boolean = true,
    @SerializedName("serial_number")
    @Expose
    var serial: String,
)