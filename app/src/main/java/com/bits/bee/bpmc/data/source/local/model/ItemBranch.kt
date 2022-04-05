package com.bits.bee.bpmc.data.source.local.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = ItemBranch.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = BranchEntitiy::class,
            parentColumns = [BranchEntitiy.ID],
            childColumns = [ItemBranch.BRANCH_ID],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = Item::class,
            parentColumns = [Item.ID],
            childColumns = [ItemBranch.ITEM_ID],
            onDelete = CASCADE
        )
    ]
)
data class ItemBranch(
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