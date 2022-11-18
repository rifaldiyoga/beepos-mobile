package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemDummyEntity
import com.bits.bee.bpmc.data.data_source.local.model.SaleAddOnDEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface ItemDummyDao : BaseDao<ItemDummyEntity> {

    @Query("SELECT * FROM item_dummy")
    fun getItemList() : List<ItemDummyEntity>

    @Query("SELECT * FROM item_dummy ORDER BY id DESC LIMIT 1")
    fun getLastId(): ItemDummyEntity

}