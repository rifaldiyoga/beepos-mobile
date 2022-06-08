package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = UnitEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = ItemEntity::class,
            parentColumns = [ItemEntity.ID],
            childColumns = [UnitEntity.ITEM_ID]
        ),
    ]
)
data class UnitEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = ITEM_ID, index = true)
    var itemId : Int,
    @ColumnInfo(name = IDX)
    var idx: Int,
    @ColumnInfo(name = UNIT)
    var unit: String,
    @ColumnInfo(name = CONV)
    var conv : Int,
) {
    companion object {
        const val TBL_NAME = "unit"

        const val ID = "id"
        const val ITEM_ID = "item_id"
        const val IDX = "idx"
        const val UNIT = "unit"
        const val CONV = "conv"

    }
}