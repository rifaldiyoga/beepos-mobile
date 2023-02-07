package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize
import java.util.ArrayList

@Parcelize
data class VariantResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean,
    @SerializedName("data")
    @Expose
    var variantModels: List<VariantModel> = ArrayList()
) : Parcelable {

    @Parcelize
    data class VariantModel (
        @SerializedName("id")
        @Expose
        var id: Int = 0,
        @SerializedName("code")
        @Expose
        var code: String,
        @SerializedName("name")
        @Expose
        var name: String,
        @SerializedName("itemgrp1_id")
        @Expose
        var itgrpId: Int = 0,
        @SerializedName("isactive")
        @Expose
        var isActive: Boolean = false,
        @SerializedName("created_at")
        @Expose
        var createdAt: String,
    ) : Parcelable

}