package com.bits.bee.bpmc.data.source.local.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = Edc.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = BranchEntitiy::class,
            parentColumns = [BranchEntitiy.ID],
            childColumns = [Edc.BRANCH_ID],
            onDelete = CASCADE
        )
    ]
)
data class Edc(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = CODE)
    var code : String,
    @ColumnInfo(name = CASH_ID)
    var cash: Int,
    @ColumnInfo(name = NOTE)
    var note : String,
    @ColumnInfo(name = SURCPAYTO)
    var surcPayTo : String,
    @ColumnInfo(name = BRANCH_ID, index = true)
    var branchId: Int,
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

    }
}