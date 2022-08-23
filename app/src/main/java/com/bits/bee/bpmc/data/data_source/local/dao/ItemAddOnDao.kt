package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemAddOnEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface ItemAddOnDao : BaseDao<ItemAddOnEntity>{

    @Query("SELECT * FROM itemaddon")
    fun getItemAddOnList() : List<ItemAddOnEntity>

    @Query("SELECT * FROM itemaddon where item_id = :itemId")
    fun getItemAddOnByItem(itemId : Int) : ItemAddOnEntity?

}