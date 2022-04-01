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
    var id : Int,
    @ColumnInfo(name = DATE_TRANS)
    var trxDate : Long,
    @ColumnInfo(name = AMOUNT)
    var amount: BigDecimal,
    @ColumnInfo(name = NOTE)
    var note : String,
    @ColumnInfo(name = STATUS)
    var status: Boolean,
    @ColumnInfo(name = REFTYPE)
    var refType : String,
    @ColumnInfo(name = AUTOGEN)
    var autoGen : String,
    @ColumnInfo(name = CASH_ID, index = true)
    var cashAId: Int,
    @ColumnInfo(name = OPERATOR_ID, index = true)
    var operatorId: Int,
    @ColumnInfo(name = CASHIER_ID, index = true)
    var cashierId: Int,
    @ColumnInfo(name = ISUPLOADED)
    var isUploaded: Boolean,
    @ColumnInfo(name = KODE_CADJ)
    var kodeCadj : String,
    @ColumnInfo(name = REFNO)
    var refNo : String,
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