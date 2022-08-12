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

    @Query("SELECT * FROM item " +
            "WHERE ispos = 1 AND active = 1 AND name1 LIKE '%' || :query || '%' AND usepid = :usePid " +
            "AND id NOT IN (SELECT item_id FROM item_variant) "+
            "AND id NOT IN (SELECT item_id FROM item_branch) "+
            "ORDER BY name1")
    fun getActiveItemList(query : String, usePid : Boolean = false) : PagingSource<Int, ItemEntity>

    @Query("SELECT * FROM item " +
            "WHERE ispos = 1 AND active = 1 AND name1 LIKE '%' || :query || '%' " +
            "AND id NOT IN (SELECT item_id FROM item_variant) "+
            "AND id NOT IN (SELECT item_id FROM item_branch) "+
            "ORDER BY name1")
    fun getActiveItemListPid(query : String ) : PagingSource<Int, ItemEntity>


    @Query("SELECT * FROM item " +
            "WHERE ispos = 1 AND active = 1 AND itemgrp1_id = :itemGrpId AND name1 LIKE '%' || :query || '%' AND usepid = :usePid " +
            "AND id NOT IN (SELECT item_id FROM item_variant) "+
            "AND id NOT IN (SELECT item_id FROM item_branch) "+
            "ORDER BY name1")
    fun getItemByItemGrpPagedList(itemGrpId : Int, query: String, usePid : Boolean = false) : PagingSource<Int, ItemEntity>

    @Query("SELECT * FROM item " +
            "WHERE ispos = 1 AND active = 1 AND itemgrp1_id = :itemGrpId AND name1 LIKE '%' || :query || '%' " +
            "AND id NOT IN (SELECT item_id FROM item_variant) "+
            "AND id NOT IN (SELECT item_id FROM item_branch) "+
            "ORDER BY name1")
    fun getItemByItemGrpPagedListPid(itemGrpId : Int, query: String) : PagingSource<Int, ItemEntity>


}