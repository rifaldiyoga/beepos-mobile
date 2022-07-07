package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.paging.PagingSource
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

    @Query("SELECT * FROM item WHERE ispos = 1 AND active = 1 AND name1 LIKE '%' || :query || '%'")
    fun getActiveItemList(query : String) : PagingSource<Int, ItemEntity>

    @Query("SELECT * FROM item WHERE ispos = 1 AND active = 1 AND itemgrp1_id = :itemGrpId LIMIT :limit OFFSET :offset")
    fun getItemByItemGrpPagedList(itemGrpId : Int, limit: Int, offset: Int) : List<ItemEntity>

}