package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.SalePromoEntity

@Dao
interface SalePromoDao: BaseDao<SalePromoEntity> {
    @Query("SELECT * FROM salepromo where sale_id = :id")
    fun getSalePromoBySale(id: Int): List<SalePromoEntity>
}