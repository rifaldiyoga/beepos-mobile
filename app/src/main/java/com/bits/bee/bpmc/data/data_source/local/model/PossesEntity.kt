package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.*

@Entity(tableName = PossesEntity.TBL_NAME,
    foreignKeys = [
//        ForeignKey(
//            entity = Operator::class,
//            parentColumns = [Operator.ID],
//            childColumns = [PossesEntity.OPERATOR_ID],
//            onDelete = ForeignKey.CASCADE
//        ),
        ForeignKey(
            entity = CashierEntity::class,
            parentColumns = [CashierEntity.ID],
            childColumns = [PossesEntity.CASHIER_ID]
        )
    ]
)
data class PossesEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var possesId : Int? = null,
    @ColumnInfo(name = TRXDATE)
    var trxDate : Date,
    @ColumnInfo(name = START_TIME)
    var startTime : Date,
    @ColumnInfo(name = END_TIME)
    var endTime : Date? = null,
    @ColumnInfo(name = START_BAL)
    var startBal : BigDecimal,
    @ColumnInfo(name = END_BAL)
    var endBal : BigDecimal?,
    @ColumnInfo(name = TOTAL)
    var total: BigDecimal ,
    @ColumnInfo(name = CREDIT)
    var credit : BigDecimal,
    @ColumnInfo(name = SHIFT)
    var shift : Int,
    @ColumnInfo(name = OPERATOR_ID, index = true)
    var operatorId : Int,
    @ColumnInfo(name = CASHIER_ID, index = true)
    var cashierId: Int,
    @ColumnInfo(name = TRXNO)
    var trxNo : String,
    @ColumnInfo(name = TOTIN)
    var totIn : BigDecimal? = null,
    @ColumnInfo(name = TOTOUT)
    var totOut : BigDecimal? = null,
    @ColumnInfo(name = ENDCASH)
    var endCash : BigDecimal,
    @ColumnInfo(name = TOTAL_ACTUAL_CASH)
    var totalActualCash : BigDecimal,
    @ColumnInfo(name = TOTAL_DIFF_CASH)
    var totalDiffCash : BigDecimal,
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