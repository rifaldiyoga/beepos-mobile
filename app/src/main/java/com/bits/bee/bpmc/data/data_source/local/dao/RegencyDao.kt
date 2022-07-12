package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.CityEntity
import com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity
import javax.inject.Singleton

@Singleton
@Dao
interface RegencyDao: BaseDao<RegencyEntity> {
    @Query("SELECT * FROM regency")
    fun getRegencyList(): List<RegencyEntity>

    @Query("SELECT * FROM regency WHERE active = 1 AND name LIKE '%'|| :query || '%'")
    fun searchRegencyList(query : String) : List<RegencyEntity>

    @Query("SELECT * FROM regency WHERE name = :name")
    fun getCodeByName(name: String): RegencyEntity

    @Query("SELECT * FROM regency WHERE code = :code")
    fun getNameByCode(code: String): RegencyEntity
}