package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = CityPopulerEntity.TBL_NAME)
data class CityPopulerEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id: Int?,
    @ColumnInfo(name = NAME_CITY)
    var name_city: String
){
    companion object{
        const val TBL_NAME = "city_populer"

        const val ID = "id"
        const val NAME_CITY = "name_city"
    }
}