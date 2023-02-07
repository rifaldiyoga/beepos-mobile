package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.bits.bee.bpmc.data.data_source.local.model.UnitDummyEntity.Companion.TBL_NAME
import java.math.BigDecimal

@Entity(tableName = TBL_NAME)
data class UnitDummyEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int?,
    @ColumnInfo(name = ITEM_ID,)
    var itemId : Int,
    @ColumnInfo(name = IDX)
    var idx: Int,
    @ColumnInfo(name = UNIT)
    var unit: String,
    @ColumnInfo(name = UNIT_UP)
    var unitUp: String,
    @ColumnInfo(name = CONV)
    var conv : BigDecimal,
) {
    companion object {
        const val TBL_NAME = "unit_dummy"

        const val ID = "id"
        const val ITEM_ID = "item_id"
        const val IDX = "idx"
        const val UNIT = "unit"
        const val UNIT_UP = "unit_up"
        const val CONV = "conv"

    }
}