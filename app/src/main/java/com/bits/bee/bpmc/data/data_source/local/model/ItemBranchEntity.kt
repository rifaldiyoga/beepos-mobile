package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = ItemBranchEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = BranchEntity::class,
            parentColumns = [BranchEntity.ID],
            childColumns = [ItemBranchEntity.BRANCH_ID],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = ItemEntity::class,
            parentColumns = [ItemEntity.ID],
            childColumns = [ItemBranchEntity.ITEM_ID],
            onDelete = CASCADE
        )
    ]
)
data class ItemBranchEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = BRANCH_ID, index = true)
    var branchId: Int,
    @ColumnInfo(name = ITEM_ID, index = true)
    var itemId: Int,
) {
    companion object {
        const val TBL_NAME = "item_branch"

        const val ID = "id"
        const val BRANCH_ID = "branch_id"
        const val ITEM_ID = "item_id"


    }
}