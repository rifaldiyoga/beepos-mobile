package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = Cstr.TBL_NAME)
data class Cstr(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = DATE_TRANS)
    var trxDate : Long,
    @ColumnInfo(name = AMOUNT_1)
    var amount1: BigDecimal,
    @ColumnInfo(name = AMOUNT_2)
    var amount2: BigDecimal,
    @ColumnInfo(name = EXRATE_1)
    var excrate1 : BigDecimal,
    @ColumnInfo(name = EXRATE_2)
    var excrate2 : BigDecimal,
    @ColumnInfo(name = NOTE)
    var note: Boolean,
    @ColumnInfo(name = REFTYPE)
    var refType : String,
    @ColumnInfo(name = REFNO)
    var refNo: String,
    @ColumnInfo(name = AUTOGEN)
    var autoGen: String,
    @ColumnInfo(name = CASHA_ID_1)
    var cashId1 : Long,
    @ColumnInfo(name = CASHA_ID_2)
    var cashId2 : Long,
    @ColumnInfo(name = ISUPLOADED)
    var isUploaded: Boolean,
    @ColumnInfo(name = KODE_CSTR)
    var kodeCstr : String,
) {
    companion object {
        const val TBL_NAME = "cstr"

        const val ID = "id"
        const val DATE_TRANS = "trxdate"
        const val AMOUNT_1 = "amount1"
        const val AMOUNT_2 = "amount2"
        const val EXRATE_1 = "exrate1"
        const val EXRATE_2 = "exrate2"
        const val NOTE = "note"
        const val REFTYPE = "reftype"
        const val REFNO = "refno"
        const val AUTOGEN = "autogen"
        const val CASHA_ID_1 = "cash_id1"
        const val CASHA_ID_2 = "cash_id2"
        const val ISUPLOADED = "isuploaded"
        const val KODE_CSTR = "kode_cstr"

    }
}