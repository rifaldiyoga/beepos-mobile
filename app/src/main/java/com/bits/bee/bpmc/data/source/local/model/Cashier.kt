package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = Cashier.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = BranchEntitiy::class,
            parentColumns = [BranchEntitiy.ID],
            childColumns = [Cashier.BRANCH_ID],
            onDelete = CASCADE
        ),
    ]
)
data class Cashier(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = CODE)
    val code : String,
    @ColumnInfo(name = CASHIER)
    val cashierName: String,
//    @ColumnInfo(name = CASHIER_ID)
//    val cashierId: Long,
    @ColumnInfo(name = BRANCH_ID, index = true)
    val branchId : Long,
    @ColumnInfo(name = CASHBRANCH_ID)
    val cashBranchId : Int,
    @ColumnInfo(name = WH_ID)
    val whId : Long,
    @ColumnInfo(name = CASH_ID)
    val cashId : Long,
    @ColumnInfo(name = ACTIVE)
    val isActive : Boolean,
    @ColumnInfo(name = STATUS)
    val status : Boolean,
) {
    companion object {
        const val TBL_NAME = "cashier"

        const val ID = "id"
        const val CODE = "code"
        const val CASHIER = "cashier_name"
        const val CASHIER_ID = "cashier_id"
        const val BRANCH_ID = "branch_id"
        const val CASHBRANCH_ID = "cashbranch_id"
        const val WH_ID = "wh_id"
        const val CASH_ID = "cash_id"
        const val ACTIVE = "active"
        const val STATUS = "status"

    }
}