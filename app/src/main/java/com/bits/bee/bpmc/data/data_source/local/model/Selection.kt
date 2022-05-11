package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Selection.TBL_NAME)
data class Selection(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = CODE)
    var code : String,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = NOTE)
    var note: String,
    @ColumnInfo(name = ISACTIVE)
    var isActive : Boolean,
    @ColumnInfo(name = ISMULTISELECT)
    var isMultiSelect : Boolean,
    @ColumnInfo(name = ISMULTIQTY)
    var isMultiQty : Boolean,
) {
    companion object {
        const val TBL_NAME = "selection"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
        const val NOTE = "note"
        const val ISACTIVE = "isactive"
        const val ISMULTISELECT = "ismultiselect"
        const val ISMULTIQTY = "ismultiqty"

    }
}