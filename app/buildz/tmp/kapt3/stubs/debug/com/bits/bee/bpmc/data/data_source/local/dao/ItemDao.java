package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\'J&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\'J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\'J.\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\'J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\'J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0007H\'J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\'\u00a8\u0006\u0016"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/ItemEntity;", "deleteAll", "", "getActiveItemList", "Landroidx/paging/PagingSource;", "", "query", "", "usePid", "", "getActiveItemListPid", "getItemByItemGrpPagedList", "itemGrpId", "getItemByItemGrpPagedListPid", "getItemBySelection", "", "selectionId", "getItemByVariant", "variantId", "getItemList", "app_debug"})
public abstract interface ItemDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.ItemEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM item")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.ItemEntity> getItemList();
    
    @androidx.room.Query(value = "DELETE FROM item")
    public abstract void deleteAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM item WHERE ispos = 1 AND active = 1 AND name1 LIKE \'%\' || :query || \'%\' AND usepid = :usePid AND is_variant = 0 AND id NOT IN (SELECT item_id FROM item_variant) AND id NOT IN (SELECT item_id FROM item_branch) UNION SELECT id, code, name as name1, \'\' as brand_id, \'\' as itemtype_code, 0 as usepid, 0 as uniqepid, itgrp_id as itemgrp1_id, 0 as isstock, 1 as issale, \'\' as unitdesc, \'\' as note, 1 as active, 0 as saleunit, 0 as stockunit, 0 as itemqty, 1 as ispos, \'\' as type, 0 as favorit, isavailable as is_available, \'1\' as is_variant, \'\' as vcode, \'\' as vcolor from variant WHERE name1 LIKE \'%\' || :query || \'%\' ORDER BY name1 ")
    public abstract androidx.paging.PagingSource<java.lang.Integer, com.bits.bee.bpmc.data.data_source.local.model.ItemEntity> getActiveItemList(@org.jetbrains.annotations.NotNull()
    java.lang.String query, boolean usePid);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM item WHERE ispos = 1 AND active = 1 AND name1 LIKE \'%\' || :query || \'%\' AND is_variant = 0 AND id NOT IN (SELECT item_id FROM item_variant) AND id NOT IN (SELECT item_id FROM item_branch) UNION SELECT id, code, name as name1, \'\' as brand_id, \'\' as itemtype_code, 0 as usepid, 0 as uniqepid, itgrp_id as itemgrp1_id, 0 as isstock, 1 as issale, \'\' as unitdesc, \'\' as note, 1 as active, 0 as saleunit, 0 as stockunit, 0 as itemqty, 1 as ispos, \'\' as type, 0 as favorit, isavailable as is_available, \'1\' as is_variant, \'\' as vcode, \'\' as vcolor from variant WHERE name1 LIKE \'%\' || :query || \'%\' ORDER BY name1 ")
    public abstract androidx.paging.PagingSource<java.lang.Integer, com.bits.bee.bpmc.data.data_source.local.model.ItemEntity> getActiveItemListPid(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM item WHERE ispos = 1 AND active = 1 AND name1 LIKE \'%\' || :query || \'%\' AND itemgrp1_id = :itemGrpId AND is_variant = 0 AND usepid = :usePid AND id NOT IN (SELECT item_id FROM item_variant) AND id NOT IN (SELECT item_id FROM item_branch) UNION SELECT id, code, name as name1, \'\' as brand_id, \'\' as itemtype_code, 0 as usepid, 0 as uniqepid, itgrp_id as itemgrp1_id, 0 as isstock, 1 as issale, \'\' as unitdesc, \'\' as note, 1 as active, 0 as saleunit, 0 as stockunit, 0 as itemqty, 1 as ispos, \'\' as type, 0 as favorit, isavailable as is_available, \'1\' as is_variant, \'\' as vcode, \'\' as vcolor from variant WHERE name1 LIKE \'%\' || :query || \'%\' AND itemgrp1_id = :itemGrpId ORDER BY name1 ")
    public abstract androidx.paging.PagingSource<java.lang.Integer, com.bits.bee.bpmc.data.data_source.local.model.ItemEntity> getItemByItemGrpPagedList(int itemGrpId, @org.jetbrains.annotations.NotNull()
    java.lang.String query, boolean usePid);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM item WHERE ispos = 1 AND active = 1 AND name1 LIKE \'%\' || :query || \'%\' AND itemgrp1_id = :itemGrpId AND is_variant = 0 AND id NOT IN (SELECT item_id FROM item_variant) AND id NOT IN (SELECT item_id FROM item_branch) UNION SELECT id, code, name as name1, \'\' as brand_id, \'\' as itemtype_code, 0 as usepid, 0 as uniqepid, itgrp_id as itemgrp1_id, 0 as isstock, 1 as issale, \'\' as unitdesc, \'\' as note, 1 as active, 0 as saleunit, 0 as stockunit, 0 as itemqty, 1 as ispos, \'\' as type, 0 as favorit, isavailable as is_available, \'1\' as is_variant, \'\' as vcode, \'\' as vcolor from variant WHERE name1 LIKE \'%\' || :query || \'%\' AND itemgrp1_id = :itemGrpId ORDER BY name1 ")
    public abstract androidx.paging.PagingSource<java.lang.Integer, com.bits.bee.bpmc.data.data_source.local.model.ItemEntity> getItemByItemGrpPagedListPid(int itemGrpId, @org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT a.* FROM item a JOIN selectiond b ON b.item_id = a.id WHERE b.selection_id = :selectionId")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.ItemEntity> getItemBySelection(int selectionId);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT a.* FROM item a JOIN item_variant b ON b.item_id = a.id WHERE b.variant_id = :variantId")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.ItemEntity> getItemByVariant(int variantId);
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public final class DefaultImpls {
    }
}