package com.bits.bee.bpmc.data.data_source.remote.post

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class SendOtpPost (
    @SerializedName("otp_tipe")
    @Expose
    var otpTipe: String,
    @SerializedName("regid")
    @Expose
    var regId: String,
)