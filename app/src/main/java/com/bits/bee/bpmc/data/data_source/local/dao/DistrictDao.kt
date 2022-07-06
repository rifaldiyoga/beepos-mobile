package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.DistrictEntity
import javax.inject.Singleton

@Singleton
@Dao
interface DistrictDao: BaseDao<DistrictEntity> {
    @Query("SELECT * FROM district")
    fun getDistrictList(): List<DistrictEntity>

    @Query("SELECT * FROM district where regency_code = :code")
    fun getDistrictByCode(code: String): List<DistrictEntity>
}