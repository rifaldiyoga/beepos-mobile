package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by aldi on 29/03/22.
 */
@Entity(tableName = PmtdEntity.TBL_NAME)
data class PmtdEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int?,
    @ColumnInfo(name = IDX)
    var idx : Int?,
    @ColumnInfo(name = CODE)
    var code : String,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = CASH_ID)
    var cashId : Int?,
    @ColumnInfo(name = MDREXP)
    var mdrExp : String?,
    @ColumnInfo(name = MDRACC)
    var mdrAcc : Int,
    @ColumnInfo(name = SURCEXP)
    var surExp : String?,
    @ColumnInfo(name = SURCACC)
    var surAcc : Int,
    @ColumnInfo(name = BRANCH_ID)
    var branchId : Int?,
    @ColumnInfo(name = SETTLEDAYS)
    var settleDays : Int?,
    @ColumnInfo(name = CASH_NAME)
    var cashName : String?,
    @ColumnInfo(name = BRANCH_NAME)
    var branchName : String?,
    @ColumnInfo(name = CCTYPE)
    var ccType : String,
    @ColumnInfo(name = EDCSURCTYPE)
    var edcSurcType : String
) {
    companion object {
        const val TBL_NAME = "pmtd"

        const val ID = "id"
        const val IDX = "idx"
        const val CODE = "code"
        const val NAME = "name"
        const val CASH_ID = "cash_id"
        const val MDREXP = "mdrexp"
        const val MDRACC = "mdracc"
        const val SURCEXP = "surcexp"
        const val SURCACC = "surcacc"
        const val BRANCH_ID = "branch_id"
        const val SETTLEDAYS = "settledays"
        const val ACTIVE = "active"
        const val CASH_NAME = "cash_name"
        const val BRANCH_NAME = "branch_name"
        const val CCTYPE = "cctype"
        const val EDCSURCTYPE = "edcsurctype"
    }
}