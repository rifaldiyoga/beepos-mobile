package com.bits.bee.bpmc.data.data_source.remote.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class DbPost (
    @SerializedName("username")
    @Expose
    var username: String,
    @SerializedName("dbname")
    @Expose
    var dbname: String
)