package com.bits.bee.bpmc.data.source.local.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = EdcSurc.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Edc::class,
            parentColumns = [Edc.ID],
            childColumns = [EdcSurc.EDC_ID],
            onDelete = CASCADE
        )
    ]
)
data class EdcSurc(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = EDCSURCN0)
    val edcSurcNo : String,
    @ColumnInfo(name = EDC_ID, index = true)
    val edcId: Int,
    @ColumnInfo(name = CCTYPE)
    val ccType : String,
    @ColumnInfo(name = CCTYPEDESC)
    val ccTypeDesc : String,
    @ColumnInfo(name = SURCEXP)
    val surcExp : String,
    @ColumnInfo(name = MDREXP)
    val mdrExp : String,
    @ColumnInfo(name = SURCACC_ID)
    val surcAccId : Int,
    @ColumnInfo(name = MDRACC_ID)
    val mdrAccId : Int,
    @ColumnInfo(name = EDCSURCTYPE)
    val edcSurcType : String,
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

    }
}