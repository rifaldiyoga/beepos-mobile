package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = EdcEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = BranchEntity::class,
            parentColumns = [BranchEntity.ID],
            childColumns = [EdcEntity.BRANCH_ID],
            onDelete = CASCADE
        )
    ]
)
data class EdcEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = CODE)
    var code : String,
    @ColumnInfo(name = NAME)
    var name : String,
    @ColumnInfo(name = CASH_ID)
    var cash: Int,
    @ColumnInfo(name = NOTE)
    var note : String,
    @ColumnInfo(name = SURCPAYTO)
    var surcPayTo : String?,
    @ColumnInfo(name = BRANCH_ID)
    var branchId: Int?,
    @ColumnInfo(name = ACTIVE)
    var active: Boolean,
) {
    companion object {
        const val TBL_NAME = "edc"

        const val ID = "id"
        const val CODE = "code"
        const val CASH_ID = "cash_id"
        const val NAME = "name"
        const val NOTE = "note"
        const val SURCPAYTO = "surcpayto"
        const val BRANCH_ID = "branch_id"
        const val ACTIVE = "active"

    }
}