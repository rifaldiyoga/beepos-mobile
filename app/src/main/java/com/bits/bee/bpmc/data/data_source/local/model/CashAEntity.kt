    package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = CashAEntity.TBL_NAME,
    foreignKeys = [
    ]
)
data class CashAEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int? = null,
    @ColumnInfo(name = DATE_TRANS)
    var trxDate : String,
    @ColumnInfo(name = AMOUNT)
    var amount: BigDecimal,
    @ColumnInfo(name = NOTE)
    var note: String,
    @ColumnInfo(name = STATUS)
    var inOut : String,
    @ColumnInfo(name = REFTYPE)
    var refType : String,
    @ColumnInfo(name = REFID)
    var refId : Long,
    @ColumnInfo(name = AUTOGEN)
    var autoGen : Boolean,
    @ColumnInfo(name = CASH_ID,)
    var cashId: Int,
    @ColumnInfo(name = USER_ID,)
    var userId: Int,
    @ColumnInfo(name = CASHIER_ID,)
    var cashierId: Int,
    @ColumnInfo(name = IS_VOID,)
    var isVoid: Boolean = false
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
        const val IS_VOID = "is_void"

    }
}