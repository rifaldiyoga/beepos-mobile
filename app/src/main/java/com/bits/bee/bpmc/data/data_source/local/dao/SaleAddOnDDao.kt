package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.SaleAddOnDEntity
import com.bits.bee.bpmc.data.data_source.local.model.SaleAddOnEntity
import com.bits.bee.bpmc.domain.model.SaleAddOnD

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface SaleAddOnDDao : BaseDao<SaleAddOnDEntity>{
    @Query("SELECT * from saleaddond where saledaddon_id = :id")
    fun getSaleAddonDbyAddon(id: Int): List<SaleAddOnDEntity>
}