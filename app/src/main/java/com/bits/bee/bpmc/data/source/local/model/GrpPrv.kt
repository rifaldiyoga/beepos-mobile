package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//asd
@Entity(tableName = GrpPrv.TBL_NAME)
data class GrpPrv(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = UPDATE_AT)
    var updatedAt : Long,
    @ColumnInfo(name = OBJ_CODE)
    var objCode : String,
    @ColumnInfo(name = ACS_TYPE)
    var acsType : String,
    @ColumnInfo(name = IS_ENABLE)
    var isEnable : String,
    @ColumnInfo(name = ACS_VAL)
    var acsVal : String,
    @ColumnInfo(name = GRP_ID)
    var grpId : String,
    @ColumnInfo(name = CODE_OBJ)
    var codeObj : String,
    @ColumnInfo(name =  UP_CODE)
    var upCode : String,
    @ColumnInfo(name = MODUL_CODE)
    var moduleCode : String,
    @ColumnInfo(name = NAME_OBJ)
    var nameObj : String,
    @ColumnInfo(name = MNEMONIC)
    var mnemonic : String,
    @ColumnInfo(name = LEVEL)
    var level : Int,
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