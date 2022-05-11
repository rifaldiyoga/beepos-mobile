package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*
import java.math.BigDecimal

@Entity(tableName = Sale.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Posses::class,
            parentColumns = [Posses.ID],
            childColumns = [Sale.POSSES_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Operator::class,
            parentColumns = [Operator.ID],
            childColumns = [Sale.OPERATOR_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Cashier::class,
            parentColumns = [Cashier.ID],
            childColumns = [Sale.CASHIER_ID]
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
            childColumns = [Sale.BP_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ChannelEntity::class,
            parentColumns = [ChannelEntity.ID],
            childColumns = [Sale.CHANNEL_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Sale(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = TRXORDERNUM)
    var trxOrderNum : Int,
    @ColumnInfo(name = TRXNO)
    var trxNo : String,
    @ColumnInfo(name = DRAFT)
    var isDraft : Boolean,
    @ColumnInfo(name = SUBTOTAL)
    var subtotal : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = TOTAL)
    var total : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = OPRNAME)
    var oprName: String,
    @ColumnInfo(name = CASHIERNAME)
    var cashiername : String,
    @ColumnInfo(name = TRXDATE)
    var trxDate : Long,
    @ColumnInfo(name = TOTPAID)
    var totPaid : BigDecimal,
    @ColumnInfo(name = TOTCHANGE)
    var totChange: BigDecimal,
    @ColumnInfo(name = TAXAMT)
    var taxAmt : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = DISCAMT)
    var discAmt : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = POSSES_ID, index = true)
    var possesId : Int,
    @ColumnInfo(name = POS_KODE)
    var kodePosses : String,
    @ColumnInfo(name = DISCEXP)
    var discExp : String,
    @ColumnInfo(name = OPERATOR_ID, index = true)
    var operatorId: Int,
    @ColumnInfo(name = CASHIER_ID, index = true)
    var cashierId: Int,
    @ColumnInfo(name = BP_ID, index = true)
    var bpId: Int,
    @ColumnInfo(name = CUST)
    var custName : String,
    @ColumnInfo(name = TERMTYPE)
    var termType: String,
    @ColumnInfo(name = ISUPLOAD)
    var isUploaded: Boolean,
    @ColumnInfo(name = ISVOID)
    var isVoid: Boolean,
    @ColumnInfo(name = GOPAY_URL)
    var gopayUrl: String,
    @ColumnInfo(name = GOPAY_TRANSACTIONID)
    var gopayTransactionId: String,
    @ColumnInfo(name = GOPAY_PAYMENTSTATUS)
    var gopayPaymentStatus: String,
    @ColumnInfo(name = ROUNDING)
    var rounding: BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = CHANNEL_ID, index = true)
    var channelId: Int,
    @ColumnInfo(name = VOID_NOTE)
    var voidNote: String,
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