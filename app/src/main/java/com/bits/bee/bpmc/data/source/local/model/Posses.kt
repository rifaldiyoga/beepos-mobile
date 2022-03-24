package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = Posses.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Operator::class,
            parentColumns = [Operator.ID],
            childColumns = [Posses.OPERATOR_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Cashier::class,
            parentColumns = [Cashier.ID],
            childColumns = [Posses.CASHIER_ID]
        )
    ]
)
data class Posses(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val possesId : Int,
    @ColumnInfo(name = TRXDATE)
    val trxDate : Long,
    @ColumnInfo(name = START_TIME)
    val startTime : Long,
    @ColumnInfo(name = END_TIME)
    val endTime : Long,
    @ColumnInfo(name = START_BAL)
    val startBal : BigDecimal,
    @ColumnInfo(name = END_BAL)
    val endBal : BigDecimal,
    @ColumnInfo(name = TOTAL)
    val total: BigDecimal ,
    @ColumnInfo(name = CREDIT)
    val credit : BigDecimal,
    @ColumnInfo(name = SHIFT)
    val shift : Int,
    @ColumnInfo(name = OPERATOR_ID, index = true)
    val operatorId : Int,
    @ColumnInfo(name = CASHIER_ID, index = true)
    val cashierId: Int,
    @ColumnInfo(name = TRXNO)
    val trxNo : String,
    @ColumnInfo(name = TOTIN)
    val totIn : BigDecimal,
    @ColumnInfo(name = TOTOUT)
    val totOut : BigDecimal,
    @ColumnInfo(name = ENDCASH)
    val endCash : BigDecimal,
    @ColumnInfo(name = TOTAL_ACTUAL_CASH)
    val totalActualCash : BigDecimal,
    @ColumnInfo(name = TOTAL_DIFF_CASH)
    val totalDiffCash : BigDecimal,
) {
    companion object {
        const val TBL_NAME = "posses"

        const val ID = "id"
        const val TRXDATE = "trxdate"
        const val START_TIME = "starttime"
        const val END_TIME = "endtime"
        const val START_BAL = "startbal"
        const val END_BAL = "endbal"
        const val TOTAL = "total"
        const val CREDIT = "credit"
        const val SHIFT = "shift"
        const val OPERATOR_ID = "op_id"
        const val CASHIER_ID = "cashier_id"
        const val TRXNO = "trxno"
        const val KODE_POSSES = "kode_posses"
        const val TOTIN = "totin"
        const val TOTOUT = "totout"
        const val ENDCASH = "endcash"
        const val TOTAL_ACTUAL_CASH = "totactualcash"
        const val TOTAL_DIFF_CASH = "totdiffcash"

    }
}