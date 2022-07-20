package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TaxEntity.TBL_NAME)
data class TaxEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int?,
    @ColumnInfo(name = CODE)
    var code : String,
    @ColumnInfo(name = NAME)
    var name : String,
    @ColumnInfo(name = EXPR)
    var expr : String,
    @ColumnInfo(name = ACTIVE)
    var isActive : Boolean,
    @ColumnInfo(name = ISDEFAULT)
    var isDefault : Boolean,
) {
    companion object {
        const val TBL_NAME = "tax"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
        const val EXPR = "expr"
        const val ACTIVE = "active"
        const val ISDEFAULT = "isdefault"

    }
}