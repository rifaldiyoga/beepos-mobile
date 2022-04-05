package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = License.TBL_NAME)
data class License(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = SERIAL)
    var licNumber : String,
    @ColumnInfo(name = ITEM)
    var item : String,
    @ColumnInfo(name = EXPDATE)
    var licExp : Long,
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