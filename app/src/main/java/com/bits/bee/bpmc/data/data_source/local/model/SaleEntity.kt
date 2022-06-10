package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*
import java.math.BigDecimal

@Entity(tableName = SaleEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = PossesEntity::class,
            parentColumns = [PossesEntity.ID],
            childColumns = [SaleEntity.POSSES_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Operator::class,
            parentColumns = [Operator.ID],
            childColumns = [SaleEntity.OPERATOR_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CashierEntity::class,
            parentColumns = [CashierEntity.ID],
            childColumns = [SaleEntity.CASHIER_ID]
        ),
        ForeignKey(
            entity = Operator::class,
            parentColumns = [Operator.ID],
            childColumns = [Cadj.OPERATOR_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = BpEntity::class,
            parentColumns = [BpEntity.ID],
            childColumns = [SaleEntity.BP_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ChannelEntity::class,
            parentColumns = [ChannelEntity.ID],
            childColumns = [SaleEntity.CHANNEL_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SaleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int? = null,
    @ColumnInfo(name = TRXORDERNUM)
    var trxOrderNum : Int = -1,
    @ColumnInfo(name = TRXNO)
    var trxNo : String = "",
    @ColumnInfo(name = DRAFT)
    var isDraft : Boolean = false,
    @ColumnInfo(name = SUBTOTAL)
    var subtotal : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = TOTAL)
    var total : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = OPRNAME)
    var oprName: String = "",
    @ColumnInfo(name = CASHIERNAME)
    var cashiername : String = "",
    @ColumnInfo(name = TRXDATE)
    var trxDate : Long = -1,
    @ColumnInfo(name = TOTPAID)
    var totPaid : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = TOTCHANGE)
    var totChange: BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = TAXAMT)
    var taxAmt : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = DISCAMT)
    var discAmt : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = POSSES_ID, index = true)
    var possesId : Int = -1,
    @ColumnInfo(name = POS_KODE)
    var kodePosses : String = "",
    @ColumnInfo(name = DISCEXP)
    var discExp : String = "",
    @ColumnInfo(name = OPERATOR_ID, index = true)
    var operatorId: Int = -1,
    @ColumnInfo(name = CASHIER_ID, index = true)
    var cashierId: Int = -1,
    @ColumnInfo(name = BP_ID, index = true)
    var bpId: Int = -1,
    @ColumnInfo(name = CUST)
    var custName : String = "",
    @ColumnInfo(name = TERMTYPE)
    var termType: String = "",
    @ColumnInfo(name = ISUPLOAD)
    var isUploaded: Boolean = false,
    @ColumnInfo(name = ISVOID)
    var isVoid: Boolean = false,
    @ColumnInfo(name = GOPAY_URL)
    var gopayUrl: String = "",
    @ColumnInfo(name = GOPAY_TRANSACTIONID)
    var gopayTransactionId: String = "",
    @ColumnInfo(name = GOPAY_PAYMENTSTATUS)
    var gopayPaymentStatus: String = "",
    @ColumnInfo(name = ROUNDING)
    var rounding: BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = CHANNEL_ID, index = true)
    var channelId: Int = -1,
    @ColumnInfo(name = VOID_NOTE)
    var voidNote: String = "",
) {
    companion object {
        const val TBL_NAME = "sale"

        const val ID = "id"
        const val TRXORDERNUM = "trx_ordernum"
        const val TRXNO = "trx_no"
        const val DRAFT = "draft"
        const val OPRNAME = "opr_name"
        const val CASHIERNAME = "cashier_name"
        const val TRXDATE = "trx_date"
        const val SUBTOTAL = "subtotal"
        const val TOTAL = "total"
        const val TOTPAID = "paidamt"
        const val TOTCHANGE = "changeamt"
        const val TAXAMT = "taxamt"
        const val DISCAMT = "discamt"
        const val DISCEXP = "discexp"
        const val POSSES_ID = "posses_id"
        const val POS_KODE = "kode_posses"
        const val OPERATOR_ID = "op_id"
        const val CASHIER_ID = "cashier_id"
        const val BP_ID = "bp_id"
        const val CUST = "cust"
        const val TERMTYPE = "termtype"
        const val ISUPLOAD = "isuploaded"
        const val ISVOID = "isvoid"
        const val GOPAY_URL = "url_qrcode"
        const val GOPAY_TRANSACTIONID = "transaction_id"
        const val GOPAY_PAYMENTSTATUS = "gopay_paymentstatus"
        const val ROUNDING = "rounding"
        const val CHANNEL_ID = "channel_id"
        const val VOID_NOTE = "void_note"

    }
}