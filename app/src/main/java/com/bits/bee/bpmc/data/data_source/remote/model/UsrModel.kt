package com.bits.bee.bpmc.data.data_source.remote.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 13/07/22.
 */
@Parcelize
data class UsrModel (
    @SerializedName("login")
    @Expose
    var login: String = "",
    @SerializedName("name")
    @Expose
    var name: String = "",
    @SerializedName("id")
    @Expose
    var id: String = "",
    @SerializedName("pin")
    @Expose
    var pin: String? = "",
    @SerializedName("active")
    @Expose
    var active: Boolean = true,
    @SerializedName("auth_key")
    @Expose
    var authKey: String? = "",
    @SerializedName("ipos")
    @Expose
    var isPos: Boolean = true,
) : Parcelable