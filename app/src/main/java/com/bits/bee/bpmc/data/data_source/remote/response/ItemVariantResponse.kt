package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import java.util.ArrayList
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemVariantResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean = false,

    @SerializedName("data")
    @Expose
    var itemVariantModels: List<ItemVariantModel> = ArrayList()
) : Parcelable {

    @Parcelize
    data class ItemVariantModel (
        @SerializedName("id")
        @Expose
        var id: Int = -1,

        @SerializedName("item_id")
        @Expose
        var itemId: Int = -1,

        @SerializedName("variant_id")
        @Expose
        var variantId: Int = -1,
    ) : Parcelable
}