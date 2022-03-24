package com.bits.bee.bpmc.data.source.local.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import java.math.BigDecimal

@Entity(tableName = Cadj.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Cash::class,
            parentColumns = [Cash.ID],
            childColumns = [Cadj.CASH_ID],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = Operator::class,
            parentColumns = [Operator.ID],
            childColumns = [Cadj.OPERATOR_ID],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = Cashier::class,
            parentColumns = [Cashier.ID],
            childColumns = [Cadj.CASHIER_ID]
        )
    ]
)
data class Cadj(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = DATE_TRANS)
    val trxDate : Long,
    @ColumnInfo(name = AMOUNT)
    val amount: BigDecimal,
    @ColumnInfo(name = NOTE)
    val note : String,
    @ColumnInfo(name = STATUS)
    val status: Boolean,
    @ColumnInfo(name = REFTYPE)
    val refType : String,
    @ColumnInfo(name = AUTOGEN)
    val autoGen : String,
    @ColumnInfo(name = CASH_ID, index = true)
    val cashAId: Int,
    @ColumnInfo(name = OPERATOR_ID, index = true)
    val operatorId: Int,
    @ColumnInfo(name = CASHIER_ID, index = true)
    val cashierId: Int,
    @ColumnInfo(name = ISUPLOADED)
    val isUploaded: Boolean,
    @ColumnInfo(name = KODE_CADJ)
    val kodeCadj : String,
    @ColumnInfo(name = REFNO)
    val refNo : String,
) {
    companion object {
        const val TBL_NAME = "cadj"

        const val ID = "id"
        const val DATE_TRANS = "trxdate"
        const val AMOUNT = "amount"
        const val NOTE = "note"
        const val STATUS = "inout"
        const val REFTYPE = "reftype"
        const val AUTOGEN = "autogen"
        const val CASH_ID = "cash_id"
        const val OPERATOR_ID = "op_id"
        const val CASHIER_ID = "cashier_id"
        const val ISUPLOADED = "isuploaded"
        const val KODE_CADJ = "kode_cadj"
        const val REFNO = "refno"


    }
}