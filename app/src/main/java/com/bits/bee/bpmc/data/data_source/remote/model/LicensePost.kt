package com.bits.bee.bpmc.data.data_source.remote.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




/**
 * Created by aldi on 06/09/22
 */
data class LicensePost (
    @SerializedName("email")
    @Expose
    private var email: String,

    @SerializedName("deviceinfo")
    @Expose
    private var deviceinfo: String,

    @SerializedName("devicetype")
    @Expose
    private var type: String,

    @SerializedName("reactivate")
    @Expose
    private var reactive: Boolean,

    @SerializedName("deviceversion")
    @Expose
    private var version: String,

    @SerializedName("selectedlicense")
    @Expose
    private var selectedlicense: String = "",

    )