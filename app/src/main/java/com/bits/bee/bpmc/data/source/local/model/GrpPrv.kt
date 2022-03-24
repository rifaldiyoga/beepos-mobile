package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//asd
@Entity(tableName = GrpPrv.TBL_NAME)
data class GrpPrv(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = UPDATE_AT)
    val updatedAt : Long,
    @ColumnInfo(name = OBJ_CODE)
    val objCode : String,
    @ColumnInfo(name = ACS_TYPE)
    val acsType : String,
    @ColumnInfo(name = IS_ENABLE)
    val isEnable : String,
    @ColumnInfo(name = ACS_VAL)
    val acsVal : String,
    @ColumnInfo(name = GRP_ID)
    val grpId : String,
    @ColumnInfo(name = CODE_OBJ)
    val codeObj : String,
    @ColumnInfo(name =  UP_CODE)
    val upCode : String,
    @ColumnInfo(name = MODUL_CODE)
    val moduleCode : String,
    @ColumnInfo(name = NAME_OBJ)
    val nameObj : String,
    @ColumnInfo(name = MNEMONIC)
    val mnemonic : String,
    @ColumnInfo(name = LEVEL)
    val level : Int,
) {
    companion object {
        const val TBL_NAME = "grpprv"

        const val ID = "id"
        const val OBJ_CODE = "obj_code"
        const val ACS_TYPE = "acstype"
        const val IS_ENABLE = "enabled"
        const val ACS_VAL = "acsval"
        const val GRP_ID = "grp_id"
        const val UPDATE_AT = "updated_at"
        const val CODE_OBJ = "code"
        const val UP_CODE = "up_code"
        const val MODUL_CODE = "modul_code"
        const val NAME_OBJ = "name"
        const val MNEMONIC = "mnemonic"
        const val LEVEL = "level"

    }
}