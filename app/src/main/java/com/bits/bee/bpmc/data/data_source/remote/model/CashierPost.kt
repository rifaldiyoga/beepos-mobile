package com.bits.bee.bpmc.data.data_source.remote.model

import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


/**
 * Created by aldi on 07/09/22
 */
@Parcelize
class CashierPost (
    @SerializedName("cashier_id")
    @Expose
    private var cashierid: Int,
    @SerializedName("serial_number")
    @Expose
    private var serial_number: String,
    @SerializedName("device_info")
    @Expose
    private var device_info: String,
): Parcelable