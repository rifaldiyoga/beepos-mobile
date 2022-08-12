package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bits.bee.bpmc.data.data_source.local.model.StockEntity.Companion.TBL_NAME

@Entity(tableName = TBL_NAME)
data class StockEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)  
    var id : Int? = null,
    @ColumnInfo(name = ITEM_ID)
    var itemId: Int = -1,
    @ColumnInfo(name = WH_ID)
    var whId: Int = -1,
    @ColumnInfo(name = ITEM_CODE)
    var itemCode: String = "",
    @ColumnInfo(name = WH_CODE)
    var whCode: String? = "",
    @ColumnInfo(name = PID)
    var pid: String = "",
    @ColumnInfo(name = QTY)
    var qty: String = "",
    @ColumnInfo(name = QTYX)
    var qtyx: String = "",
    @ColumnInfo(name = ACTIVE)
    var active: Boolean = false,
) {
    companion object {
        const val TBL_NAME = "stock"

        const val ID = "id"
        const val ITEM_ID = "item_id"
        const val WH_ID = "wh_id"
        const val ITEM_CODE = "item_code"
        const val WH_CODE = "wh_code"
        const val PID = "pid"
        const val QTY = "qty"
        const val QTYX = "qtyx"
        const val ACTIVE = "active"

    }
}