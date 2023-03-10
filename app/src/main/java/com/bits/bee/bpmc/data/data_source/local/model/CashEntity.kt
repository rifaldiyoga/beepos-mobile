package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = CashEntity.TBL_NAME)
data class CashEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int? = null,
    @ColumnInfo(name = CODE)
    var code: String,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = BALANCE)
    var balance : BigDecimal,
) {
    companion object {
        const val TBL_NAME = "cash"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
        const val BALANCE = "balance"

    }
}