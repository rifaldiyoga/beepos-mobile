package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.DistrictEntity
import com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity
import javax.inject.Singleton

@Singleton
@Dao
interface DistrictDao: BaseDao<DistrictEntity> {
    @Query("SELECT * FROM district")
    fun getDistrictList(): List<DistrictEntity>

    @Query("SELECT * FROM district where regency_code = :code")
    fun getListDistrictByCode(code: String): List<DistrictEntity>

    @Query("SELECT * FROM district WHERE name = :name")
    fun getCodeByName(name: String): DistrictEntity

    @Query("SELECT * FROM district WHERE code = :code")
    fun getNameByCode(code: String): DistrictEntity
}