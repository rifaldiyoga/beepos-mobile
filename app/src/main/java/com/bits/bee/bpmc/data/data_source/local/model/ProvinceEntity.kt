package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bits.bee.bpmc.domain.model.Province

@Entity(tableName = ProvinceEntity.TBL_NAME)
data class ProvinceEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = CODE)
    var code: String,
    @ColumnInfo(name = NAME)
    var name : String,
    @ColumnInfo(name = ACTIVE)
    var isActive : Boolean,
) {
    companion object {
        const val TBL_NAME = "province"

        const val CODE = "code"
        const val NAME = "name"
        const val ACTIVE = "active"

    }

    fun toProvince(): Province{
        return Province(
            code, name, isActive
        )
    }
}