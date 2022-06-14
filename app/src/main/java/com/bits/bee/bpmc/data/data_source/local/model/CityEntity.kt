package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = CityEntity.TBL_NAME)
data class CityEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = CODE)
    var code: String,
    @ColumnInfo(name = NAME)
    var name : String,
    @ColumnInfo(name = ACTIVE)
    var isActive : Boolean,
) {
    companion object {
        const val TBL_NAME = "city"

        const val CODE = "code"
        const val NAME = "name"
        const val ACTIVE = "active"

    }
}