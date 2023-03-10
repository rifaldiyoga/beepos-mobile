package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = EdcSurcEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = EdcEntity::class,
            parentColumns = [EdcEntity.ID],
            childColumns = [EdcSurcEntity.EDC_ID],
            onDelete = CASCADE
        )
    ]
)
data class EdcSurcEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = EDCSURCN0)
    var edcSurcNo : String,
    @ColumnInfo(name = EDC_ID, index = true)
    var edcId: Int,
    @ColumnInfo(name = CCTYPE)
    var ccType : String,
    @ColumnInfo(name = CCTYPEDESC)
    var ccTypeDesc : String,
    @ColumnInfo(name = SURCEXP)
    var surcExp : String,
    @ColumnInfo(name = MDREXP)
    var mdrExp : String,
    @ColumnInfo(name = SURCACC_ID)
    var surcAccId : Int,
    @ColumnInfo(name = MDRACC_ID)
    var mdrAccId : Int,
    @ColumnInfo(name = EDCSURCTYPE)
    var edcSurcType : String,
    @ColumnInfo(name = ACTIVE)
    var active : Boolean,
) {
    companion object {
        const val TBL_NAME = "edcsurc"

        const val ID = "id"
        const val EDCSURCN0 = "edcsurcno"
        const val EDC_ID = "edc_id"
        const val CCTYPE = "cctype"
        const val CCTYPEDESC = "cctypedesc"
        const val SURCEXP = "surcexp"
        const val MDREXP = "mdrexp"
        const val SURCACC_ID = "surcacc_id"
        const val MDRACC_ID = "mdracc_id"
        const val EDCSURCTYPE = "edcsurctype"
        const val ACTIVE = "active"

    }
}