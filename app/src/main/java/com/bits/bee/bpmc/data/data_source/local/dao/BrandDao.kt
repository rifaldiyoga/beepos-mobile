package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.BrandEntity
import com.bits.bee.bpmc.data.data_source.local.model.ItemGroupEntity

@Dao
interface BrandDao: BaseDao<BrandEntity> {
    @Query("SELECT * FROM brand")
    fun getBrandList(): List<BrandEntity>

    @Query("SELECT * FROM brand where name = :merk")
    fun getBrandByName(merk: String): BrandEntity

    @Query("SELECT * FROM brand where id = :id")
    fun getBrandById(id: Int): BrandEntity

    @Query("select * from brand order by id desc limit 1")
    fun getLastBrand(): BrandEntity?
}