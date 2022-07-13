package com.bits.bee.bpmc.data.data_source.remote.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 13/07/22.
 */
@Parcelize
data class RegModel (
    @SerializedName("code")
    @Expose
    var code: String = "",
    @SerializedName("name")
    @Expose
    var name: String = "",
    @SerializedName("value")
    @Expose
    var value: String = "",
    @SerializedName("isvisible")
    @Expose
    var isVisible: Boolean = false,
    @SerializedName("modul_code")
    @Expose
    var modulCode: String = "",
    @SerializedName("valeditor")
    @Expose
    var valeditor: String? = "",
) : Parcelable