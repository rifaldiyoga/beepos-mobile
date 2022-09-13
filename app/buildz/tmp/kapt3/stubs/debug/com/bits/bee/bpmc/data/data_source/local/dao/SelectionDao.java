package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

/**
 * Created by aldi on 07/06/22.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\'\u00a8\u0006\b"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/SelectionDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/SelectionEntity;", "getSelectionByItemid", "", "itemId", "", "getSelectionList", "app_debug"})
public abstract interface SelectionDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.SelectionEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM selection")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.SelectionEntity> getSelectionList();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT DISTINCT(a.id), a.code, a.name, a.note, a.isactive, a.ismultiselect, a.ismultiqty FROM selection a JOIN addond b on b.selection_id = a.id JOIN itemaddon c ON c.addon = b.addon_id WHERE c.item_id = :itemId")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.SelectionEntity> getSelectionByItemid(int itemId);
}