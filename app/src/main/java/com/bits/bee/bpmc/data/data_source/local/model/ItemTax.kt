package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = ItemTax.TBL_NAME)
data class ItemTax(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = CODE)
    var code: Int,
    @ColumnInfo(name = PURCTAX)
    var purcTax: Int,
    @ColumnInfo(name = SALETAX)
    var saleTax: Int,
) {
    companion object {
        const val TBL_NAME = "item_tax"

        const val ID = "id"
        const val CODE = "code"
        const val PURCTAX = "purctax"
        const val SALETAX = "saletax"

    }
}