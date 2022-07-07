package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = SyncEntity.TBL_NAME)
data class SyncEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = TRXNO)
    var trxNo : String,
    @ColumnInfo(name = TRXDATE)
    var trxDate: Long,
    @ColumnInfo(name = BP_ID)
    var bpId : Int,
    @ColumnInfo(name = BP_NAME)
    var bpName : String,
    @ColumnInfo(name = IS_UPLOADED)
    var isUploaded : Boolean
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