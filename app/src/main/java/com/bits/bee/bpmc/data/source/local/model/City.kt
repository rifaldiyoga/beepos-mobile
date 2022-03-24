package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = City.TBL_NAME)
data class City(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = CODE)
    val code: String,
    @ColumnInfo(name = NAME)
    val name : String,
    @ColumnInfo(name = ACTIVE)
    val isActive : Boolean,
) {
    companion object {
        const val TBL_NAME = "city"

        const val CODE = "code"
        const val NAME = "name"
        const val ACTIVE = "active"

    }
}