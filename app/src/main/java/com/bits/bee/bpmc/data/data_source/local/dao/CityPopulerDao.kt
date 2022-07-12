package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.CityEntity
import com.bits.bee.bpmc.data.data_source.local.model.CityPopulerEntity

@Dao
interface CityPopulerDao: BaseDao<CityPopulerEntity> {
    @Query("SELECT name_city, COUNT(*) AS Jml\n" +
            "FROM city_populer \n" +
            "GROUP BY name_city\n" +
            "ORDER BY Jml DESC\n" +
            "LIMIT 8")
    fun getCityPopuler() : List<CityPopulerEntity>
}