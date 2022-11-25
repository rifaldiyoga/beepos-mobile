package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemKitchenEntity
import com.bits.bee.bpmc.data.data_source.local.model.ItemSaleTaxEntity

@Dao
interface ItemKitchenDao : BaseDao<ItemKitchenEntity> {

    @Query("SELECT * FROM item_kitchen")
    fun getItemKitchen() : List<ItemKitchenEntity>


}