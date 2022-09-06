package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\'\u00a8\u0006\f"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/RegencyDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/RegencyEntity;", "getCodeByName", "name", "", "getNameByCode", "code", "getRegencyList", "", "searchRegencyList", "query", "app_debug"})
@javax.inject.Singleton()
public abstract interface RegencyDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM regency")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity> getRegencyList();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM regency WHERE active = 1 AND name LIKE \'%\'|| :query || \'%\'")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity> searchRegencyList(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM regency WHERE name = :name")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity getCodeByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM regency WHERE code = :code")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity getNameByCode(@org.jetbrains.annotations.NotNull()
    java.lang.String code);
}