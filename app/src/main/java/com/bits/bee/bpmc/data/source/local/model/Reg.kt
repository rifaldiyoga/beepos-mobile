package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Reg.TBL_NAME)
data class Reg(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = CODE)
    val code : String,
    @ColumnInfo(name = NAME)
    val name: String,
    @ColumnInfo(name = VALUE)
    val value: String,
    @ColumnInfo(name = ISVISIBLE)
    val isVisible : Boolean,
    @ColumnInfo(name = MODUL_CODE)
    val modulCode : String,
    @ColumnInfo(name = VALIDATOR)
    val validator : String,
) {
    companion object {
        const val TBL_NAME = "reg"

        const val CODE = "code"
        const val NAME = "name"
        const val VALUE = "value"
        const val ISVISIBLE = "isvisible"
        const val MODUL_CODE = "modul_code"
        const val VALIDATOR = "validator"

    }
}