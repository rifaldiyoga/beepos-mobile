package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.bits.bee.bpmc.data.data_source.local.model.BranchEntity
import com.bits.bee.bpmc.data.data_source.remote.model.ValueLabelModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.google.gson.annotations.Expose
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
    var data : MutableList<BranchModel> = mutableListOf()
):Parcelable {

    @Parcelize
    data class Data (
        @SerializedName("data")
        var data : MutableList<BranchModel> = mutableListOf()
    ) : Parcelable

    @Parcelize
    data class BranchModel(
        @SerializedName("id")
        @Expose
        var id: Int = -1,
        @SerializedName("code")
        @Expose
        var code: String,
        @SerializedName("name")
        @Expose
        var name: String,
        @SerializedName("active")
        @Expose
        var active: Boolean,
        @SerializedName("version")
        @Expose
        var version: Int,
        @SerializedName("created_at")
        @Expose
        var createdAt: String,
        @SerializedName("created_by")
        @Expose
        var createdBy: Int,
        @SerializedName("updated_at")
        @Expose
        var updatedAt: String,
        @SerializedName("updated_by")
        @Expose
        var updatedBy: Int,
        @SerializedName("branchcmpname")
        @Expose
        var cmpName: String,
        @SerializedName("branchaddress")
        @Expose
        var cmpAddress: String,
        @SerializedName("branchphone")
        @Expose
        var cmpPhone: String,
        @SerializedName("branchfax")
        @Expose
        var noFax: String,
        @SerializedName("branchtaxregno")
        @Expose
        var noNpwp: String,
        @SerializedName("branchvatregno")
        @Expose
        var noPkp: String,
        @SerializedName("branchdefaultcust")
        @Expose
        var branchDefaultCust: Int,
    ) : Parcelable

}