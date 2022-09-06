package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\'J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\'\u00a8\u0006\u000b"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/DistrictDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/DistrictEntity;", "getCodeByName", "name", "", "getDistrictList", "", "getListDistrictByCode", "code", "getNameByCode", "app_debug"})
@javax.inject.Singleton()
public abstract interface DistrictDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.DistrictEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM district")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.DistrictEntity> getDistrictList();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM district where regency_code = :code")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.DistrictEntity> getListDistrictByCode(@org.jetbrains.annotations.NotNull()
    java.lang.String code);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM district WHERE name = :name")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.DistrictEntity getCodeByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM district WHERE code = :code")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.DistrictEntity getNameByCode(@org.jetbrains.annotations.NotNull()
    java.lang.String code);
}