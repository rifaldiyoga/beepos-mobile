package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Itemgrp.TBL_NAME)
data class Itemgrp(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = CODE)
    val code : String,
    @ColumnInfo(name = NAME)
    val name: String,
    @ColumnInfo(name = LEVEL)
    val level : Int,
    @ColumnInfo(name = UP_ID)
    val upId : Int,
    @ColumnInfo(name = IS_POS)
    val isPos : Boolean,
) {
    companion object {
        const val TBL_NAME = "itemgrp"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
        const val LEVEL = "level"
        const val UP_ID = "up_id"
        const val LASTSYNC = "last_sync"
        const val IS_POS = "ispos"

    }
}