package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Usrgrp.TBL_NAME)
data class Usrgrp(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)  
    val id : Int,
    @ColumnInfo(name = USR_CODE)
    val usrCode : String,
    @ColumnInfo(name = DISABLED)
    val disabled : Boolean,
    @ColumnInfo(name = GRP_ID)
    val grpId : Int,
    @ColumnInfo(name = USR_ID)
    val bpName : String,
    @ColumnInfo(name = UPDATED_AT)
    val updatedAt : Long
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