package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = BpAccEntity.TBL_NAME,)
data class BpAccEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int? = null,
    @ColumnInfo(name = BP_ID, index = true)
    var bpId : Int? = null,
    @ColumnInfo(name = CRC_ID)
    var crcId: Int? = null,
    @ColumnInfo(name = PURCTERMTYPE)
    var purcTermType: String = "",
    @ColumnInfo(name = SALETERMTYPE)
    var saleTermType: String = "",
    @ColumnInfo(name = ISDEFAULT)
    var isDefault: Boolean = false,
) {
    companion object {
        const val TBL_NAME = "bpacc"

        const val ID = "id"
        const val BP_ID = "bp_id"
        const val CRC_ID = "crc_id"
        const val PURCTERMTYPE = "purctermtype"
        const val SALETERMTYPE = "saletermtype"
        const val ISDEFAULT = "isdefault"
    }
}