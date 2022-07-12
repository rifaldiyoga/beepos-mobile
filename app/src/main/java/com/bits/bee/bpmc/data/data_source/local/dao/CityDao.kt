package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.CityEntity
import com.bits.bee.bpmc.domain.model.City
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/03/22.
 */
@Dao
interface CityDao : BaseDao<CityEntity>{

    @Query("SELECT * FROM city")
    fun getCityList() : List<CityEntity>

    @Query("DELETE FROM city")
    fun deleteAll()

    @Query("SELECT * FROM city WHERE active = 1")
    fun getActiveCityList() : List<CityEntity>

    @Query("SELECT * FROM city WHERE active = 1 AND name LIKE '%'|| :query || '%'")
    fun searchCityList(query : String) : List<CityEntity>

    @Query("SELECT name FROM city ")
    fun getCityName(): List<String>

    @Query("SELECT * FROM city where name = :name")
    fun getCodeByName(name: String): CityEntity
}