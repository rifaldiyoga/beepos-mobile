package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

/**
 * Created by aldi on 30/06/22.
 */
@Entity(tableName = CrcEntity.TBL_NAME)
data class CrcEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int?,
    @ColumnInfo(name = CODE)
    var code : String,
    @ColumnInfo(name = NAME)
    var name : String,
    @ColumnInfo(name = SYMBOL)
    var symbol : String,
    @ColumnInfo(name = ISDEFAULT)
    var isDefault : Boolean,
    @ColumnInfo(name = EXCRATE)
    var excRate : BigDecimal,
    @ColumnInfo(name = FISRATE)
    var fisRate : BigDecimal,
    @ColumnInfo(name = RATETYPE)
    var rateType : String,
    @ColumnInfo(name = ACTIVE)
    var active : Boolean,
) {

    companion object{
        const val TBL_NAME = "crc"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
        const val SYMBOL = "symbol"
        const val ISDEFAULT = "isdefault"
        const val EXCRATE = "excrate"
        const val FISRATE = "fisrate"
        const val RATETYPE = "ratetype"
        const val ACTIVE = "active"
    }

}