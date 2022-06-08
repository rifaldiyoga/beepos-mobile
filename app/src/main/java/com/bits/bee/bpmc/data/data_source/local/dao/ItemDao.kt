package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemEntity

@Dao
interface ItemDao : BaseDao<ItemEntity> {

    @Query("SELECT * FROM item")
    fun getItemList() : List<ItemEntity>

    @Query("DELETE FROM item")
    fun deleteAll()

    @Query("SELECT * FROM item WHERE ispos = 1 AND active = 1")
    fun getActiveItemList() : List<ItemEntity>

    @Query("SELECT * FROM item WHERE ispos = 1 AND active = 1 AND itemgrp1_id = :itemGrpId")
    fun getActiveItemListByItemGrp(itemGrpId : Int) : List<ItemEntity>

}