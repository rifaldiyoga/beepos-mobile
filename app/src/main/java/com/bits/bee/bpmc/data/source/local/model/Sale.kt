package com.bits.bee.bpmc.data.source.local.model

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
            entity = Bp::class,
            parentColumns = [Bp.ID],
            childColumns = [Sale.BP_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Channel::class,
            parentColumns = [Channel.ID],
            childColumns = [Sale.CHANNEL_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Sale(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = TRXORDERNUM)
    val trxOrderNum : Int,
    @ColumnInfo(name = TRXNO)
    val trxNo : String,
    @ColumnInfo(name = DRAFT)
    val isDraft : Boolean,
    @ColumnInfo(name = SUBTOTAL)
    val subtotal : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = TOTAL)
    val total : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = OPRNAME)
    val oprName: String,
    @ColumnInfo(name = CASHIERNAME)
    val cashiername : String,
    @ColumnInfo(name = TRXDATE)
    val trxDate : Long,
    @ColumnInfo(name = TOTPAID)
    val totPaid : BigDecimal,
    @ColumnInfo(name = TOTCHANGE)
    val totChange: BigDecimal,
    @ColumnInfo(name = TAXAMT)
    val taxAmt : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = DISCAMT)
    val discAmt : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = POSSES_ID, index = true)
    val possesId : Int,
    @ColumnInfo(name = POS_KODE)
    val kodePosses : String,
    @ColumnInfo(name = DISCEXP)
    val discExp : String,
    @ColumnInfo(name = OPERATOR_ID, index = true)
    val operatorId: Int,
    @ColumnInfo(name = CASHIER_ID, index = true)
    val cashierId: Int,
    @ColumnInfo(name = BP_ID, index = true)
    val bpId: Int,
    @ColumnInfo(name = CUST)
    val custName : String,
    @ColumnInfo(name = TERMTYPE)
    val termType: String,
    @ColumnInfo(name = ISUPLOAD)
    val isUploaded: Boolean,
    @ColumnInfo(name = ISVOID)
    val isVoid: Boolean,
    @ColumnInfo(name = GOPAY_URL)
    val gopayUrl: String,
    @ColumnInfo(name = GOPAY_TRANSACTIONID)
    val gopayTransactionId: String,
    @ColumnInfo(name = GOPAY_PAYMENTSTATUS)
    val gopayPaymentStatus: String,
    @ColumnInfo(name = ROUNDING)
    val rounding: BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = CHANNEL_ID, index = true)
    val channelId: Int,
    @ColumnInfo(name = VOID_NOTE)
    val voidNote: String,
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