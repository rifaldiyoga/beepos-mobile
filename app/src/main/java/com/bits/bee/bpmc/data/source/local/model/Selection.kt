package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Selection.TBL_NAME)
data class Selection(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = CODE)
    val code : String,
    @ColumnInfo(name = NAME)
    val name: String,
    @ColumnInfo(name = NOTE)
    val note: String,
    @ColumnInfo(name = ISACTIVE)
    val isActive : Boolean,
    @ColumnInfo(name = ISMULTISELECT)
    val isMultiSelect : Boolean,
    @ColumnInfo(name = ISMULTIQTY)
    val isMultiQty : Boolean,
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