package com.bits.bee.bpmc.data.data_source.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MonitCashierPost (
    @SerializedName("cashier_id")
    @Expose
    private val cashierId : String,
    @SerializedName("last_downdate")
    @Expose
    private val lastDowndate : String,
    @SerializedName("last_syncdate")
    @Expose
    private val lastSyncdate : String
)