package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.*

@Entity(tableName = CstrEntity.TBL_NAME)
data class CstrEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int? = null,
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
        const val CREATED_AT = "created_at"
        const val CREATED_BY = "created_by"
        const val UPDATED_AT = "updated_at"
        const val UPDATED_BY = "updated_by"
    }
}