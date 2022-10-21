package com.bits.bee.bpmc.data.data_source.remote.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

/**
 * Created by aldi on 21/10/22
 */
@Parcelize
data class GopayRefundPost (
    @SerializedName("refund_key")
    @Expose
    var refund_key: String,
    @SerializedName("amount")
    @Expose
    var amount: BigDecimal,
    @SerializedName("reason")
    @Expose
    var reason: String
) : Parcelable