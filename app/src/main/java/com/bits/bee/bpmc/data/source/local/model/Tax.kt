package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Tax.TBL_NAME)
data class Tax(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = CODE)
    val code : String,
    @ColumnInfo(name = NAME)
    val name : String,
    @ColumnInfo(name = EXPR)
    val expr : String,
    @ColumnInfo(name = ACTIVE)
    val isActive : Boolean,
    @ColumnInfo(name = ISDEFAULT)
    val isDefault : Boolean,
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