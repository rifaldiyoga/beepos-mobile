package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.PriceEntity
import com.bits.bee.bpmc.domain.model.Price

@Dao
interface PriceDao : BaseDao<PriceEntity> {

    @Query("SELECT * FROM price")
    fun getPriceList() : List<PriceEntity>

    @Query("DELETE FROM price")
    fun deleteAll()

    @Query("SELECT * FROM price WHERE pricelvl_id = :id")
    fun getPriceByPriceLvl(id : Int) : PriceEntity
}