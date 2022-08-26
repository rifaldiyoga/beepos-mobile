package com.bits.bee.bpmc.data.data_source.remote.post

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BpPost(
    @SerializedName("bparray")
    @Expose
    var bpArray: MutableList<BpArray> = mutableListOf()
): Parcelable {

    @Parcelize
    data class BpArray(
        @SerializedName("code")
        @Expose
        private var code: String? = null,
        @SerializedName("businessname")
        @Expose
        var businessname: String? = null,
        @SerializedName("ownname")
        @Expose
        var ownname: String? = null,
        @SerializedName("hp")
        @Expose
        var hp: String? = null,
        @SerializedName("address")
        @Expose
        var address: String? = null,
        @SerializedName("city_code")
        @Expose
        var cityCode: String? = null,
        @SerializedName("coordinate")
        @Expose
        var coordinate: String? = null,
        @SerializedName("pricelvl_id")
        @Expose
        var pricelvl_id: String? = null,
        @SerializedName("email")
        @Expose
        var email: String? = null,
        @SerializedName("taxedonsale")
        @Expose
        var saleistaxed: Boolean = false,
        @SerializedName("taxinconsale")
        @Expose
        var saletaxinc: Boolean = false
    ): Parcelable
}