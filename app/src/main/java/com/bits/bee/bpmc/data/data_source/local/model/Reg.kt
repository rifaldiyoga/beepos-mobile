package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Reg.TBL_NAME)
data class Reg(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = CODE)
    var code : String,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = VALUE)
    var value: String,
    @ColumnInfo(name = ISVISIBLE)
    var isVisible : Boolean,
    @ColumnInfo(name = MODUL_CODE)
    var modulCode : String,
    @ColumnInfo(name = VALIDATOR)
    var validator : String,
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