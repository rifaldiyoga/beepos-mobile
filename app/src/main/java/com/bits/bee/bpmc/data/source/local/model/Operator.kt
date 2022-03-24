package com.bits.bee.bpmc.data.source.local.model

import androidx.room.*

@Entity(tableName = Operator.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = BranchEntitiy::class,
            parentColumns = [BranchEntitiy.ID],
            childColumns = [Operator.BRANCH_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Operator(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = BRANCH_ID, index = true)
    val branchId : Int,
    @ColumnInfo(name = CLOUD_LOGIN)
    val cloudLogin : String,
    @ColumnInfo(name = OPERATOR)
    val operator : String,
    @ColumnInfo(name = SANDI)
    val sandi : String,
    @ColumnInfo(name = ACTIVE)
    val active : Boolean,
) {
    companion object {
        const val TBL_NAME = "operator"

        const val ID = "id"
        const val OPERATOR = "operator"
        const val CLOUD_LOGIN = "cloud_login"
        const val BRANCH_ID = "branch_id"
        const val SANDI = "sandi"
        const val ACTIVE = "active"

    }
}