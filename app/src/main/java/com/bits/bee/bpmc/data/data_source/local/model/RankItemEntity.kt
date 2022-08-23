package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import java.math.BigDecimal

data class RankItemEntity(
    @ColumnInfo(name = "name")
    var name : String = "",
    @ColumnInfo(name = "qty")
    var qty : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = "total")
    var total: BigDecimal = BigDecimal.ZERO
)