package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = Cash.TBL_NAME)
data class Cash(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = CODE)
    val code: String,
    @ColumnInfo(name = NAME)
    val name: String,
    @ColumnInfo(name = BALANCE)
    val balance : BigDecimal,
) {
    companion object {
        const val TBL_NAME = "cash"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
        const val BALANCE = "balance"

    }
}