package com.bits.bee.bpmc.data.data_source.remote.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 13/07/22.
 */
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
    var usrId: String = "",
    @SerializedName("grp_id")
    @Expose
    var grpId: String = "",
    @SerializedName("updated_at")
    @Expose
    var updatedAt: String = ""
): Parcelable