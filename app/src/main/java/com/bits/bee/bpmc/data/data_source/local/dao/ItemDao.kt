package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemEntitiy

@Dao
interface ItemDao : BaseDao<ItemEntitiy> {

    @Query("SELECT * FROM item")
    fun getItemList() : List<ItemEntitiy>

    @Query("DELETE FROM item")
    fun deleteAll()

    @Query("SELECT * FROM item WHERE ispos = 1")
    fun getActiveItemList() : List<ItemEntitiy>

}