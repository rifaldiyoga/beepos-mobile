package com.bits.bee.bpmc.data.source.local.model

import androidx.room.*

@Entity(tableName = Salecrcvs.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Sale::class,
            parentColumns = [Sale.ID],
            childColumns = [Salecrcvs.SALE_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Edc::class,
            parentColumns = [Edc.ID],
            childColumns = [Salecrcvs.EDC_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Cash::class,
            parentColumns = [Cash.ID],
            childColumns = [Salecrcvs.CASH_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Salecrcvs(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = RCVTYPE_CODE)
    var rcvTypeCode : String,
    @ColumnInfo(name = SALE_ID, index = true)
    var saleInt: Int,
    @ColumnInfo(name = RCVAMT)
    var rcvAmt : String,
    @ColumnInfo(name = NOTE)
    var note : String,
    @ColumnInfo(name = EDC_ID, index = true)
    var edcId: Int,
    @ColumnInfo(name = CASH_ID, index = true)
    var cashId: Int,
    @ColumnInfo(name = CARD_NO)
    var cardNo : String,
    @ColumnInfo(name = CCTYPE_CODE)
    var cctypeCode : String,
    @ColumnInfo(name = MDREXP)
    var mdrExp : String,
    @ColumnInfo(name = MDRAMT)
    var mdrAmt : String,
    @ColumnInfo(name = SURCEXP)
    var surcExp : String,
    @ColumnInfo(name = SURCAMT)
    var surcAmt : String,
    @ColumnInfo(name = MDRACC_ID)
    var mdrAccId : String,
    @ColumnInfo(name = SURACC_ID)
    var surAccId : String,
    @ColumnInfo(name = REF_ID)
    var refId : String,
    @ColumnInfo(name = TRACK_NO)
    var trackNo : String,
) {
    companion object {
        const val TBL_NAME = "salecrcvs"

        const val ID = "id"
        const val RCVTYPE_CODE = "rcvtype_code"
        const val SALE_ID = "sale"
        const val RCVAMT = "rcvamt"
        const val NOTE = "note"
        const val EDC_ID = "edc_id"
        const val CASH_ID = "cash_id"
        const val CARD_NO = "card_no"
        const val CCTYPE_CODE = "cctype_code"
        const val MDREXP = "mdrexp"
        const val MDRAMT = "mdramt"
        const val SURCEXP = "surcexp"
        const val SURCAMT = "surcamt"
        const val MDRACC_ID = "mdracc_id"
        const val SURACC_ID = "surcacc_id"
        const val REF_ID = "ref_id"
        const val TRACK_NO = "track_no"


    }
}