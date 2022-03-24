package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = CashA.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Cash::class,
            parentColumns = [Cash.ID],
            childColumns = [CashA.CASH_ID],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = Operator::class,
            parentColumns = [Operator.ID],
            childColumns = [CashA.OPERATOR_ID],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = Cashier::class,
            parentColumns = [Cashier.ID],
            childColumns = [CashA.CASHIER_ID]
        )
    ]
)
data class CashA(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = DATE_TRANS)
    val trxDate : String,
    @ColumnInfo(name = AMOUNT)
    val amount: BigDecimal,
    @ColumnInfo(name = NOTE)
    val note: String,
    @ColumnInfo(name = STATUS)
    val inOut : Char,
    @ColumnInfo(name = REFTYPE)
    val refType : String,
    @ColumnInfo(name = REFID)
    val refId : Long,
    @ColumnInfo(name = AUTOGEN)
    val autoGen : Boolean,
    @ColumnInfo(name = CASH_ID, index = true)
    val cashId: Int,
    @ColumnInfo(name = OPERATOR_ID, index = true)
    val operatorId: Int,
    @ColumnInfo(name = CASHIER_ID, index = true)
    val cashierId: Int,
    @ColumnInfo(name = ISUPLOADED)
    val isUploaded: Boolean,
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
        const val OPERATOR_ID = "op_id"
        const val CASHIER_ID = "cashier_id"
        const val ISUPLOADED = "isuploaded"

    }
}