package com.bits.bee.bpmc.data.data_source.remote.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * Created by aldi on 13/07/22.
 */
@Parcelize
data class CityModel (
    @SerializedName("id")
    val id: Int = -1,
    @SerializedName("code")
    val code: String = "",
    @SerializedName("name")
    val name : String = "",
    @SerializedName("updated_at")
    val updatedAt : String = ""
) : Parcelable