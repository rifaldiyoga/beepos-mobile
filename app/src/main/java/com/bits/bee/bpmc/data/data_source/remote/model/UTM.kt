package com.bits.bee.bpmc.data.data_source.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UTM(
    @SerializedName("utm_source")
    var utm_source: String="",
    @SerializedName("utm_medium")
    var utm_medium: String="",
    @SerializedName("utm_campaign")
    var utm_campaign: String="",
    @SerializedName("utm_term")
    var utm_term: String="",
    @SerializedName("utm_content")
    var utm_content: String = ""
) : Parcelable