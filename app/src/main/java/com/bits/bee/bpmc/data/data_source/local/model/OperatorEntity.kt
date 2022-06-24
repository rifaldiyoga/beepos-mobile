package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*

@Entity(tableName = OperatorEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = BranchEntity::class,
            parentColumns = [BranchEntity.ID],
            childColumns = [OperatorEntity.BRANCH_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class OperatorEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = BRANCH_ID, index = true)
    var branchId : Int,
    @ColumnInfo(name = CLOUD_LOGIN)
    var cloudLogin : String,
    @ColumnInfo(name = OPERATOR)
    var operator : String,
    @ColumnInfo(name = SANDI)
    var sandi : String,
    @ColumnInfo(name = ACTIVE)
    var active : Boolean,
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