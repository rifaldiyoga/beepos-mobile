package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

/**
 * Created by aldi on 07/06/22.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\'\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/ItemDummyDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/ItemDummyEntity;", "getItemList", "", "app_debug"})
public abstract interface ItemDummyDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.ItemDummyEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM item_dummy")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.ItemDummyEntity> getItemList();
}