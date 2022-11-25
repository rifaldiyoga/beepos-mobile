package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = UsrGrpEntity.TBL_NAME)
data class UsrGrpEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)  
    var id : Int?,
    @ColumnInfo(name = USR_CODE)
    var usrCode : String,
    @ColumnInfo(name = DISABLED)
    var disabled : Boolean,
    @ColumnInfo(name = GRP_ID)
    var grpId : Int,
    @ColumnInfo(name = USR_ID)
    var usrId : String,
    @ColumnInfo(name = UPDATED_AT)
    var updatedAt : Date
) {
    companion object {
        const val TBL_NAME = "usrgrp"

        const val ID = "id"
        const val USR_CODE = "usr_code"
        const val DISABLED = "disabled"
        const val USR_ID = "usr_id"
        const val GRP_ID = "grp_id"
        const val UPDATED_AT = "updated_at"

    }
}