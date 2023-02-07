package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.CadjEntity
import com.bits.bee.bpmc.data.data_source.local.model.SaleAddOnEntity
import com.bits.bee.bpmc.data.data_source.local.model.SaleCrcvEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface SaleAddOnDao : BaseDao<SaleAddOnEntity>{


    @Query("SELECT * from saleaddon where id = :id")
    fun getSaleAddonById(id: Int): SaleAddOnEntity?

    @Query("SELECT * from saleaddon where sale_id = :id")
    fun getSaleAddonBySale(id: Int): SaleAddOnEntity?

}