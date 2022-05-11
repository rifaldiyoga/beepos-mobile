package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*

@Entity(tableName = SelectionD.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Selection::class,
            parentColumns = [Selection.ID],
            childColumns = [SelectionD.SELECTION_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Item::class,
            parentColumns = [Item.ID],
            childColumns = [SelectionD.ITEM_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SelectionD(
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