package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.ProvinceEntity
import javax.inject.Singleton

@Singleton
@Dao
interface ProvinceDao: BaseDao<ProvinceEntity> {
    @Query("SELECT * FROM province")
    fun getProvinceList(): List<ProvinceEntity>
}