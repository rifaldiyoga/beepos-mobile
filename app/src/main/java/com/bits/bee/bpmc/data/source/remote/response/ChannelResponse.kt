package com.bits.bee.bpmc.data.source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.source.local.model.ChannelEntity
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 29/03/22.
 */
@Parcelize
data class ChannelResponse (
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
        var data : MutableList<ChannelModel> = mutableListOf()
    ) : Parcelable

    @Parcelize
    data class ChannelModel(
        @SerializedName("id")
        var id : Int = -1,
        @SerializedName("code")
        var code : String = "",
        @SerializedName("name")
        var name: String = "",
        @SerializedName("active")
        var active: Boolean,
        @SerializedName("ispos")
        var isPos : Boolean,
        @SerializedName("created_by")
        var createdBy : Int = -1,
        @SerializedName("created_at")
        var createdAt : String,
        @SerializedName("updated_by")
        var updatedBy : Int = -1,
        @SerializedName("updated_at")
        var updatedAt : String,
        @SerializedName("color")
        var color : String = "",
        @SerializedName("pricelvl_id")
        var priceLvlId : Int? = -1,
    ) : Parcelable {

        fun toChannel() : ChannelEntity {
            return ChannelEntity(id, code, name, active, isPos, createdBy,DateFormatUtils.formatStringToDate(BPMConstants.DEFAULT_DATE_FORMAT, createdAt).time, updatedBy, DateFormatUtils.formatStringToDate(
                BPMConstants.DEFAULT_DATE_FORMAT, updatedAt).time, color, priceLvlId)
        }

    }

}