package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

/**
 * Created by aldi on 20/05/22.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\'\u00a8\u0006\n"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/StockDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/StockEntity;", "getStockByItem", "", "itemId", "", "getStockByItemAndWh", "", "whId", "app_debug"})
public abstract interface StockDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.StockEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM stock WHERE item_id = :itemId AND wh_id = :whId")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.StockEntity> getStockByItemAndWh(int itemId, int whId);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM stock WHERE item_id = :itemId")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.StockEntity> getStockByItem(@org.jetbrains.annotations.NotNull()
    java.lang.String itemId);
}