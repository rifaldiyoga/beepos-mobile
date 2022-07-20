    package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = CashAEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = CashEntity::class,
            parentColumns = [CashEntity.ID],
            childColumns = [CashAEntity.CASH_ID],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = [UserEntity.ID],
            childColumns = [CashAEntity.USER_ID],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = CashierEntity::class,
            parentColumns = [CashierEntity.ID],
            childColumns = [CashAEntity.CASHIER_ID]
        )
    ]
)
data class CashAEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int?,
    @ColumnInfo(name = DATE_TRANS)
    var trxDate : String,
    @ColumnInfo(name = AMOUNT)
    var amount: BigDecimal,
    @ColumnInfo(name = NOTE)
    var note: String,
    @ColumnInfo(name = STATUS)
    var inOut : Char,
    @ColumnInfo(name = REFTYPE)
    var refType : String,
    @ColumnInfo(name = REFID)
    var refId : Long,
    @ColumnInfo(name = AUTOGEN)
    var autoGen : Boolean,
    @ColumnInfo(name = CASH_ID, index = true)
    var cashId: Int,
    @ColumnInfo(name = USER_ID, index = true)
    var userId: Int,
    @ColumnInfo(name = CASHIER_ID, index = true)
    var cashierId: Int,
    @ColumnInfo(name = ISUPLOADED)
    var isUploaded: Boolean,
) {
    companion object {
        const val TBL_NAME = "casha"

        const val ID = "id"
        const val DATE_TRANS = "trxdate"
        const val AMOUNT = "amount"
        const val NOTE = "note"
        const val STATUS = "inout"
        const val REFTYPE = "reftype"
        const val REFID = "refid"
        const val AUTOGEN = "autogen"
        const val CASH_ID = "cash_id"
        const val USER_ID = "user_id"
        const val CASHIER_ID = "cashier_id"
        const val ISUPLOADED = "isuploaded"

    }
}