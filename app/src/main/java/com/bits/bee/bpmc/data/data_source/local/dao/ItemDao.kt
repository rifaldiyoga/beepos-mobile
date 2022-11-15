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
            "WHERE ispos = 1 AND active = 1 AND name1 LIKE '%' || :query || '%' AND usepid = :usePid AND is_variant = 0 " +
            "AND id NOT IN (SELECT item_id FROM item_variant) "+
            "AND id NOT IN (SELECT item_id FROM item_branch) " +
            "UNION SELECT id, code, name as name1, '' as brand_id, '' as itemtype_code, 0 as usepid, 0 as uniqepid, " +
            "itgrp_id as itemgrp1_id, 0 as isstock, 1 as issale, '' as unitdesc, '' as note, 1 as active, 0 as saleunit, " +
            "0 as stockunit, 0 as itemqty, 1 as ispos, '' as type, isfavorit as favorit, isavailable as is_available, '1' as is_variant, " +
            "'' as vcode, '' as vcolor from variant WHERE name1 LIKE '%' || :query || '%' "+
            "ORDER BY name1 ")
    fun getActiveItemPagedList(query : String, usePid : Boolean = false) : PagingSource<Int, ItemEntity>

    @Query("SELECT * FROM item " +
            "WHERE ispos = 1 AND active = 1 AND name1 LIKE '%' || :query || '%' AND favorit = 1 AND is_variant = 0 " +
            "AND id NOT IN (SELECT item_id FROM item_variant) "+
            "AND id NOT IN (SELECT item_id FROM item_branch) " +
            "UNION SELECT id, code, name as name1, '' as brand_id, '' as itemtype_code, 0 as usepid, 0 as uniqepid, " +
            "itgrp_id as itemgrp1_id, 0 as isstock, 1 as issale, '' as unitdesc, '' as note, 1 as active, 0 as saleunit, " +
            "0 as stockunit, 0 as itemqty, 1 as ispos, '' as type, isfavorit as favorit, isavailable as is_available, '1' as is_variant, " +
            "'' as vcode, '' as vcolor from variant WHERE name1 LIKE '%' || :query || '%' AND favorit = 1 "+
            "ORDER BY name1 ")
    fun getFavoriteItemPagedList(query : String) : PagingSource<Int, ItemEntity>


    @Query("SELECT * FROM item " +
            "WHERE ispos = 1 AND active = 1 AND name1 LIKE '%' || :query || '%' " +
            "AND id NOT IN (SELECT item_id FROM item_variant) "+
            "AND id NOT IN (SELECT item_id FROM item_branch) " +
            "ORDER BY name1 ")
    fun getActiveItemPagedListPid(query : String) : PagingSource<Int, ItemEntity>

    @Query("SELECT * FROM item " +
            "WHERE ispos = 1 AND active = 1 AND name1 LIKE '%' || :query || '%' AND itemgrp1_id = :itemGrpId AND is_variant = 0 AND usepid = :usePid " +
            "AND id NOT IN (SELECT item_id FROM item_variant) "+
            "AND id NOT IN (SELECT item_id FROM item_branch) " +
            "UNION SELECT id, code, name as name1, '' as brand_id, '' as itemtype_code, 0 as usepid, 0 as uniqepid, " +
            "itgrp_id as itemgrp1_id, 0 as isstock, 1 as issale, '' as unitdesc, '' as note, 1 as active, 0 as saleunit, " +
            "0 as stockunit, 0 as itemqty, 1 as ispos, '' as type, isfavorit as favorit, isavailable as is_available, '1' as is_variant, " +
            "'' as vcode, '' as vcolor from variant WHERE name1 LIKE '%' || :query || '%' AND itemgrp1_id = :itemGrpId "+
            "ORDER BY name1 ")
    fun getItemByItemGrpPagedList(itemGrpId : Int, query: String, usePid : Boolean = false) : PagingSource<Int, ItemEntity>

    @Query("SELECT * FROM item " +
            "WHERE ispos = 1 AND active = 1 AND name1 LIKE '%' || :query || '%' AND itemgrp1_id = :itemGrpId " +
            "AND id NOT IN (SELECT item_id FROM item_variant) "+
            "AND id NOT IN (SELECT item_id FROM item_branch) " +
            "ORDER BY name1 ")
    fun getItemByItemGrpPagedListPid(itemGrpId : Int, query: String) : PagingSource<Int, ItemEntity>

    @Query("SELECT a.* FROM item a JOIN selectiond b ON b.item_id = a.id WHERE b.selection_id = :selectionId")
    fun getItemBySelection(selectionId : Int) : List<ItemEntity>

    @Query("SELECT a.* FROM item a JOIN item_variant b ON b.item_id = a.id WHERE b.variant_id = :variantId")
    fun getItemByVariant(variantId : Int) : List<ItemEntity>

    @Query("SELECT * FROM item where id = :id")
    fun getItemById(id: Int): ItemEntity?

    @Query("SELECT * FROM item WHERE active = 1 AND ispos = 1")
    fun getActiveItemList() : List<ItemEntity>

    @Query("SELECT * FROM item WHERE active = 1 AND ispos = 1 AND itemgrp1_id = :itemGrpId")
    fun getActiveItemListByItemGrp(itemGrpId: Int) : List<ItemEntity>

    @Query("SELECT a.* from item a JOIN itemgrp b ON a.itemgrp1_id = b.id JOIN printer_kitchend c ON c.kitchen_id = b.id JOIN printer_kitchen d ON d.id = c.printer_kitchen_id WHERE d.id = :id")
    fun getItemByPrinterKitchen(id: Int) : List<ItemEntity>

    @Query("SELECT * FROM item where name1 like '%' || :query || '%' and active = 1")
    fun cariItems(query: String): List<ItemEntity>

}