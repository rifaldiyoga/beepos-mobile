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
    val id : Int,
    @ColumnInfo(name = CODE)
    val code : String,
    @ColumnInfo(name = NAME)
    val name: String,
    @ColumnInfo(name = BRANCH_ID, index = true)
    val branchId: Int,
    @ColumnInfo(name = CREATED_BY)
    val createdBy : Int,
    @ColumnInfo(name = CREATED_AT)
    val createdAt : Long,
    @ColumnInfo(name = UPDATED_BY)
    val updatedBy : Int,
    @ColumnInfo(name = UPDATED_AT)
    val updatedAt : Long,
    @ColumnInfo(name = IS_USED)
    val isUsed : Boolean,
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