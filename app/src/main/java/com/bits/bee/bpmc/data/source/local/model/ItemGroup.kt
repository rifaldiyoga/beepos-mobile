package com.bits.bee.bpmc.data.source.local.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = ItemGroup.TBL_NAME)
data class ItemGroup(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = CODE)
    var code : String,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = LEVEL)
    var level : Int,
    @ColumnInfo(name = UP_ID)
    var upId : Int,
    @ColumnInfo(name = IS_POS)
    var isPos : Boolean,
) : Parcelable {
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