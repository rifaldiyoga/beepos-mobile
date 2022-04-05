package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Cctype.TBL_NAME)
data class Cctype(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = CCTYPE)
    var cctype: String,
    @ColumnInfo(name = CCTYPEDESC)
    var cctypeDesc : String,
) {
    companion object {
        const val TBL_NAME = "cc_type"

        const val ID = "id"
        const val CCTYPE = "cctype"
        const val CCTYPEDESC = "cctypedesc"

    }
}