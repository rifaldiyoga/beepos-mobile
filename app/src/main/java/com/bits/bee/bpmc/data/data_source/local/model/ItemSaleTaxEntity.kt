package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ItemSaleTaxEntity.TBL_NAME)
data class ItemSaleTaxEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int? = null,
    @ColumnInfo(name = TAXCODE)
    var code: String,
    @ColumnInfo(name = CALCMTD)
    var calcMtd: String,
    @ColumnInfo(name = EXPR)
    var expr: String,
    @ColumnInfo(name = EXPR_NOREG)
    var exprNoReg: String,
) {
    companion object {
        const val TBL_NAME = "item_tax"

        const val ID = "id"
        const val TAXCODE = "tax_code"
        const val CALCMTD = "calcmtd"
        const val EXPR = "expr"
        const val EXPR_NOREG = "expr_noreg"

    }
}