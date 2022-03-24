package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = License.TBL_NAME)
data class License(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = NAME)
    val name: String,
    @ColumnInfo(name = SERIAL)
    val licNumber : String,
    @ColumnInfo(name = ITEM)
    val item : String,
    @ColumnInfo(name = EXPDATE)
    val licExp : Long,
) {
    companion object {
        const val TBL_NAME = "license"

        const val ID = "id"
        const val NAME = "name"
        const val SERIAL = "serial_number"
        const val ITEM = "item"
        const val EXPDATE = "expdate"
    }
}