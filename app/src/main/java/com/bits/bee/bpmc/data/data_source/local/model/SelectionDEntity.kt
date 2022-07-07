package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*

@Entity(tableName = SelectionDEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = SelectionEntity::class,
            parentColumns = [SelectionEntity.ID],
            childColumns = [SelectionDEntity.SELECTION_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ItemEntity::class,
            parentColumns = [ItemEntity.ID],
            childColumns = [SelectionDEntity.ITEM_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SelectionDEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = SELECTION_ID, index = true)
    var selectionId: Int,
    @ColumnInfo(name = DNO)
    var dno: Int,
    @ColumnInfo(name = ITEM_ID, index = true)
    var itemId: Int,
) {
    companion object {
        const val TBL_NAME = "selectiond"

        const val ID = "id"
        const val SELECTION_ID = "selection_id"
        const val DNO = "dno"
        const val ITEM_ID = "item_id"

    }
}