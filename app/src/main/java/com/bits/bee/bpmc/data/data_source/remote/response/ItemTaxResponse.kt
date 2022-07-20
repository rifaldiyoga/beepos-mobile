package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


/**
 * Created by aldi on 14/07/22.
 */
@Parcelize
data class ItemTaxResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean,

    @SerializedName("data")
    @Expose
    var data: List<ItemTaxData> = ArrayList()

) :Parcelable {

    @Parcelize
    data class ItemTaxData (
        @SerializedName("id")
        @Expose
        var id: Int?,
        @SerializedName("code")
        @Expose
        var code: String?,

        @SerializedName("purctax")
        @Expose
        var purctax: String,

        @SerializedName("saletax")
        @Expose
        var saletax: String?,
    ) : Parcelable
}