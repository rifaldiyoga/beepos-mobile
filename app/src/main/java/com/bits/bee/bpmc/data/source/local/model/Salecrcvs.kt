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
    val id : Int,
    @ColumnInfo(name = RCVTYPE_CODE)
    val rcvTypeCode : String,
    @ColumnInfo(name = SALE_ID, index = true)
    val saleInt: Int,
    @ColumnInfo(name = RCVAMT)
    val rcvAmt : String,
    @ColumnInfo(name = NOTE)
    val note : String,
    @ColumnInfo(name = EDC_ID, index = true)
    val edcId: Int,
    @ColumnInfo(name = CASH_ID, index = true)
    val cashId: Int,
    @ColumnInfo(name = CARD_NO)
    val cardNo : String,
    @ColumnInfo(name = CCTYPE_CODE)
    val cctypeCode : String,
    @ColumnInfo(name = MDREXP)
    val mdrExp : String,
    @ColumnInfo(name = MDRAMT)
    val mdrAmt : String,
    @ColumnInfo(name = SURCEXP)
    val surcExp : String,
    @ColumnInfo(name = SURCAMT)
    val surcAmt : String,
    @ColumnInfo(name = MDRACC_ID)
    val mdrAccId : String,
    @ColumnInfo(name = SURACC_ID)
    val surAccId : String,
    @ColumnInfo(name = REF_ID)
    val refId : String,
    @ColumnInfo(name = TRACK_NO)
    val trackNo : String,
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