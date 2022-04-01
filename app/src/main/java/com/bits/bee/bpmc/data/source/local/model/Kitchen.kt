package com.bits.bee.bpmc.data.source.local.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = Kitchen.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = BranchEntitiy::class,
            parentColumns = [BranchEntitiy.ID],
            childColumns = [Kitchen.BRANCH_ID],
            onDelete = CASCADE
        )
    ]
)
data class Kitchen(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = CODE)
    var code : String,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = BRANCH_ID, index = true)
    var branchId: Int,
    @ColumnInfo(name = CREATED_BY)
    var createdBy : Int,
    @ColumnInfo(name = CREATED_AT)
    var createdAt : Long,
    @ColumnInfo(name = UPDATED_BY)
    var updatedBy : Int,
    @ColumnInfo(name = UPDATED_AT)
    var updatedAt : Long,
    @ColumnInfo(name = IS_USED)
    var isUsed : Boolean,
) {
    companion object {
        const val TBL_NAME = "kitchen"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
        const val BRANCH_ID = "branch_id"
        const val CREATED_AT = "created_at"
        const val CREATED_BY = "created_by"
        const val UPDATED_AT = "updated_at"
        const val UPDATED_BY = "updated_by"
        const val IS_USED = "is_used"
    }
}