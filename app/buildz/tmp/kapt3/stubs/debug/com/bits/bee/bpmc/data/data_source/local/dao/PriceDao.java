package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\'J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\'\u00a8\u0006\u000b"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/PriceDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/PriceEntity;", "deleteAll", "", "getPriceByPriceLvlItem", "priceLvlId", "", "itemId", "getPriceList", "", "app_debug"})
public abstract interface PriceDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.PriceEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM price")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.PriceEntity> getPriceList();
    
    @androidx.room.Query(value = "DELETE FROM price")
    public abstract void deleteAll();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM price WHERE pricelvl_id = :priceLvlId AND itemid = :itemId")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.PriceEntity getPriceByPriceLvlItem(int priceLvlId, int itemId);
}