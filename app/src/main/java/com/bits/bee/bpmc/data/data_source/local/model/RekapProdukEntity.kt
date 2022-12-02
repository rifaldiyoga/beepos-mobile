package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import java.math.BigDecimal
import java.util.Date

data class RekapProdukEntity(
    @ColumnInfo(name = "item_id")
    var itemId: Int,
    @ColumnInfo(name = "item_code")
    var itemCode: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name ="qty")
    var qty: BigDecimal? = null,
    @ColumnInfo(name = "subtotal")
    var subtotal : BigDecimal? = null,
    @ColumnInfo(name = "draft")
    var draft: Boolean = false,
    @ColumnInfo(name = "isvoid")
    var isVoid: Boolean = false,
    @ColumnInfo(name = "trx_date")
    var trxDate: Date? = null
)