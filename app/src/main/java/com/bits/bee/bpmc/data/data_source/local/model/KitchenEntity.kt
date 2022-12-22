package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = KitchenEntity.TBL_NAME,
    foreignKeys = [
    ]
)
data class KitchenEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = CODE)
    var code : String? = null,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = BRANCH_ID)
    var branchId: Int = 0,
    @ColumnInfo(name = CREATED_BY)
    var createdBy : Int = 0,
    @ColumnInfo(name = CREATED_AT)
    var createdAt : Long = 0,
    @ColumnInfo(name = UPDATED_BY)
    var updatedBy : Int = 0,
    @ColumnInfo(name = UPDATED_AT)
    var updatedAt : Long = 0,
    @ColumnInfo(name = IS_USED)
    var isUsed : Boolean = false,
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