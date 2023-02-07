package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.local.model.ItemGroupEntity
import com.bits.bee.bpmc.data.data_source.remote.model.ItemGroupModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 29/03/22.
 */
@Parcelize
data class ItemGroupResponse (
    @SerializedName("status")
    var status:Boolean = false,
//    @SerializedName("message")
//    var msg : String = "",
    @SerializedName("data")
    var data : MutableList<ItemGroupModel> = mutableListOf(),
//    @SerializedName("total_page")
//    var totalPage : Int = 1,
): Parcelable {

    @Parcelize
    data class Data (
        @SerializedName("data")
        var data : MutableList<ItemGroupModel> = mutableListOf(),
        @SerializedName("total_page")
        var totalPage : Int = -1,
        ) : Parcelable



}