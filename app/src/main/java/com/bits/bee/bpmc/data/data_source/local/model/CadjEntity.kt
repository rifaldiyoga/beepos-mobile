package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import java.math.BigDecimal
import java.util.*

@Entity(tableName = CadjEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = CashEntity::class,
            parentColumns = [CashEntity.ID],
            childColumns = [CadjEntity.CASH_ID],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = [UserEntity.ID],
            childColumns = [CadjEntity.OPERATOR_ID],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = CashierEntity::class,
            parentColumns = [CashierEntity.ID],
            childColumns = [CadjEntity.CASHIER_ID]
        )
    ]
)
data class CadjEntity(
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
    @ColumnInfo(name = CREATED_AT)
    var createdAt: Date = Date(),
    @ColumnInfo(name = CREATED_BY)
    var createdBy: Int = -1,
    @ColumnInfo(name = UPDATED_AT)
    var updatedAt: Date = Date(),
    @ColumnInfo(name = UPDATED_BY)
    var updatedBy: Int = -1,
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
        const val CREATED_AT = "created_at"
        const val CREATED_BY = "created_by"
        const val UPDATED_AT = "updated_at"
        const val UPDATED_BY = "updated_by"


    }
}