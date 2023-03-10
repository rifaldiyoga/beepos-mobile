package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*
import java.math.BigDecimal
import java.util.*

@Entity(tableName = SaleEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = PossesEntity::class,
            parentColumns = [PossesEntity.ID],
            childColumns = [SaleEntity.POSSES_ID],
        ),
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
    var trxDate : Date = Date(),
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
    @ColumnInfo(name = USER_ID, index = true)
    var userId: Int = -1,
    @ColumnInfo(name = CASHIER_ID, index = true)
    var cashierId: Int = -1,
    @ColumnInfo(name = BP_ID, index = true)
    var bpId: Int = -1,
    @ColumnInfo(name = BP_NAME)
    var bpName : String = "",
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
    @ColumnInfo(name = CREATED_AT)
    var createdAt: Date = Date(),
    @ColumnInfo(name = CREATED_BY)
    var createdBy: Int = -1,
    @ColumnInfo(name = UPDATED_AT)
    var updatedAt: Date = Date(),
    @ColumnInfo(name = UPDATED_BY)
    var updatedBy: Int = -1,
    @ColumnInfo(name = CRC_ID, index = true)
    var crcId: Int? = -1,
    @ColumnInfo(name = SREP_ID, index = true)
    var srepId: Int? = -1,
    @ColumnInfo(name = EXCRATE)
    var excrate: BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = FISRATE)
    var fisrate: BigDecimal = BigDecimal.ZERO,
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
        const val USER_ID = "user_id"
        const val CASHIER_ID = "cashier_id"
        const val BP_ID = "bp_id"
        const val BP_NAME = "bp_name"
        const val TERMTYPE = "termtype"
        const val ISUPLOAD = "isuploaded"
        const val ISVOID = "isvoid"
        const val GOPAY_URL = "url_qrcode"
        const val GOPAY_TRANSACTIONID = "transaction_id"
        const val GOPAY_PAYMENTSTATUS = "gopay_paymentstatus"
        const val ROUNDING = "rounding"
        const val CHANNEL_ID = "channel_id"
        const val VOID_NOTE = "void_note"
        const val CREATED_AT = "created_at"
        const val CREATED_BY = "created_by"
        const val UPDATED_AT = "updated_at"
        const val UPDATED_BY = "updated_by"
        const val CRC_ID = "crc_id"
        const val SREP_ID = "srep_id"
        const val EXCRATE = "excrate"
        const val FISRATE = "fisrate"

    }
}