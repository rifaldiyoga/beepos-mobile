package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Sync.TBL_NAME)
data class Sync(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = TRXNO)
    val trxNo : String,
    @ColumnInfo(name = TRXDATE)
    val trxDate: Long,
    @ColumnInfo(name = BP_ID)
    val bpId : Int,
    @ColumnInfo(name = BP_NAME)
    val bpName : String,
    @ColumnInfo(name = IS_UPLOADED)
    val isUploaded : Boolean
) {
    companion object {
        const val TBL_NAME = "sync"

        const val ID = "id"
        const val TRXNO = "trx_no"
        const val TRXDATE = "trxdate"
        const val BP_ID = "bp_id"
        const val BP_NAME = "bp_name"

        const val IS_UPLOADED = "isuploaded"

    }
}