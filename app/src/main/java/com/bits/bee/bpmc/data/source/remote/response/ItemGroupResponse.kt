package com.bits.bee.bpmc.data.source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.source.local.model.ItemGroup
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 29/03/22.
 */
@Parcelize
data class ItemGroupResponse (
    @SerializedName("status")
    var status:Boolean = false,
    @SerializedName("message")
    var msg : String = "",
    @SerializedName("data")
    var data : Data
): Parcelable {

    @Parcelize
    data class Data (
        @SerializedName("data")
        var data : MutableList<ItemGroupModel> = mutableListOf()
    ) : Parcelable

    @Parcelize
    data class ItemGroupModel(
        @SerializedName("id")
        val id : Int = -1,
        @SerializedName("code")
        val code : String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("level")
        val level : Int = -1,
        @SerializedName("up_id")
        val upId : Int = -1,
        @SerializedName("ispos")
        val isPos : Boolean,
    ) : Parcelable {

        fun toItemGroup() : ItemGroup {
            return ItemGroup(id, code, name, level, upId, isPos)
        }

    }

}