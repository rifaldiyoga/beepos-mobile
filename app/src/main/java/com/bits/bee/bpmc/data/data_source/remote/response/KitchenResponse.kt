package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import java.util.ArrayList
import kotlinx.parcelize.Parcelize

@Parcelize
data class KitchenResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean = false,
    @SerializedName("data")
    @Expose
    var kitchenModels: List<KitchenModel> = ArrayList()
) :Parcelable{

    @Parcelize
    data class KitchenModel (
        @SerializedName("id")
        @Expose
        var id: Int = -1,

        @SerializedName("code")
        @Expose
        var code: String = "",

        @SerializedName("name")
        @Expose
        var name: String = "",

        @SerializedName("branch_id")
        @Expose
        var branchId: Int = -1,

        @SerializedName("created_at")
        @Expose
        var createdAt: String = "",

        @SerializedName("created_by")
        @Expose
        var createdBy: Int = -1,

        @SerializedName("updated_at")
        @Expose
        var updatedAt: String = "",

        @SerializedName("updated_by")
        @Expose
        var updatedBy: Int = -1,
    ) : Parcelable
}