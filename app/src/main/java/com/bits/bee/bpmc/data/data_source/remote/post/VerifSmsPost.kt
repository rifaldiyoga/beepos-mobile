package com.bits.bee.bpmc.data.data_source.remote.post

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class VerifSmsPost(
    @SerializedName("status")
    @Expose
    var status: Boolean,
    @SerializedName("regid")
    @Expose
    var regid : Int,
    @SerializedName("code")
    @Expose
    var code : String ,
):Parcelable