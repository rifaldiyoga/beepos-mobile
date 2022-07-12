package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

/**
 * Created by bits on 09/09/16.
 */
@Parcelize
data class ItemBranchResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean = false,

    @SerializedName("data")
    @Expose
    var itemBranch: ItemBranch
) : Parcelable {

    @Parcelize
    data class ItemBranch (
        @SerializedName("item_branch")
        @Expose
        var itemBranchModels: List<ItemBranchModel> = mutableListOf()
    ) : Parcelable

    @Parcelize
    data class ItemBranchModel (
        @SerializedName("item_id")
        @Expose
        var itemId: Int = -1,
        @SerializedName("branch_id")
        @Expose
        var branchId: Int = -1,
        @SerializedName("id")
        @Expose
        var id: Int = -1,
    ) : Parcelable

}