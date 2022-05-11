package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.City

/**
 * Created by aldi on 30/03/22.
 */
@Dao
interface CityDao : BaseDao<City>{

    @Query("SELECT * FROM city")
    fun getCityList() : List<City>

    @Query("DELETE FROM city")
    fun deleteAll()

    @Query("SELECT name FROM city ")
    fun getCityName(): List<String>
}