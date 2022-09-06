package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = CityEntity.TBL_NAME)
data class CityEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id: Int? = null,
    @ColumnInfo(name = CODE)
    var code: String,
    @ColumnInfo(name = NAME)
    var name : String,
//    @ColumnInfo(name = ACTIVE)
//    var isActive : Boolean,
    @ColumnInfo(name = UPDATED_AT)
    var updatedAt : Date,
) {
    companion object {
        const val TBL_NAME = "city"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
//        const val ACTIVE = "active"
        const val UPDATED_AT = "updated_at"

    }
}