package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.local.model.BranchEntity
import com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class BranchResponse (
    @SerializedName("status")
    var status:Boolean = false,
    @SerializedName("message")
    var msg : String = "",
    @SerializedName("data")
    var data : Data
):Parcelable {

    @Parcelize
    data class Data (
        @SerializedName("data")
        var data : MutableList<BranchModel> = mutableListOf()
    ) : Parcelable

    @Parcelize
    data class BranchModel(
        @SerializedName("id")
        val id : Int = -1,
        @SerializedName("code")
        val code : String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("version")
        val version: String = "",
        @SerializedName("cmpname")
        val cmpName : String = "",
        @SerializedName("phone")
        val phone : String = "",
        @SerializedName("active")
        val active : Boolean = false,
        @SerializedName("address")
        val cmpAddress : String = "",
        @SerializedName("fax")
        val cmpFax : String = "",
        @SerializedName("custdeft_id")
        val custDeftId : ValueLabelModel?,
        @SerializedName("created_at")
        val createdAt : String = "",
        @SerializedName("created_by")
        val createdBy : Int = -1,
        @SerializedName("updated_at")
        val updatedAt : String = "",
        @SerializedName("updated_by")
        val updatedBy : Int = -1,
    ) : Parcelable {


        fun toBranchEntity() : BranchEntity {
            return BranchEntity(
                id, code, name, version, cmpName, phone, active, cmpAddress, cmpFax, custDeftId?.let { it.value }, DateFormatUtils.formatStringToDate(BPMConstants.DEFAULT_DATE_FORMAT, createdAt).time, createdBy, DateFormatUtils.formatStringToDate(BPMConstants.DEFAULT_DATE_FORMAT, createdAt).time, updatedBy
            )
        }

    }

}