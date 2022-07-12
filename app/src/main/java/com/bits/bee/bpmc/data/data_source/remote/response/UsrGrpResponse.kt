package com.bits.bee.bpmc.data.data_source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by Med
 */
@Parcelize
data class UsrGrpResponse (
    @SerializedName("status")
    @Expose
    var status: Boolean = false,

    @SerializedName("data")
    @Expose
    var data: List<UsrGrpModel> = mutableListOf()
) : Parcelable {

    @Parcelize
    data class UsrGrpModel (
        @SerializedName("id")
        @Expose
        var id: Int = -1,

        @SerializedName("usr_code")
        @Expose
        var usrCode: String = "",

        @SerializedName("disabled")
        @Expose
        var isDisabled: Boolean = false,

        @SerializedName("usr_id")
        @Expose
        var usrId: Int = -1,

        @SerializedName("grp_id")
        @Expose
        var grpId: Int = -1,

        @SerializedName("updated_at")
        @Expose
        var updatedAt: String = ""
    ): Parcelable
}