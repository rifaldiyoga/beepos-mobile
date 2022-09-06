package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0006\u001a\u00020\u0002H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\'\u00a8\u0006\t"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/KitchenDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/KitchenEntity;", "getByKitchenId", "id", "", "getLastKitchen", "read", "", "app_debug"})
@javax.inject.Singleton()
public abstract interface KitchenDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.KitchenEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM kitchen WHERE id = :id")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.KitchenEntity getByKitchenId(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM kitchen ORDER BY id DESC LIMIT 1")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.KitchenEntity getLastKitchen();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM  kitchen")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.KitchenEntity> read();
}