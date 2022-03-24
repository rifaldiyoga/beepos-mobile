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
    val id : Int,
    @ColumnInfo(name = CODE)
    val code : String,
    @ColumnInfo(name = CASH_ID)
    val cash: Int,
    @ColumnInfo(name = NOTE)
    val note : String,
    @ColumnInfo(name = SURCPAYTO)
    val surcPayTo : String,
    @ColumnInfo(name = BRANCH_ID, index = true)
    val branchId: Int,
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