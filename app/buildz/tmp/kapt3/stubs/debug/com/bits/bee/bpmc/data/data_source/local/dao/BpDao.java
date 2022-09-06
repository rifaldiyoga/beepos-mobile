package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

/**
 * Created by aldi on 17/03/22.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\'J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\'J\b\u0010\u000f\u001a\u00020\u0002H\'J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\'\u00a8\u0006\u0013"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/BpDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/BpEntity;", "getBpByDate", "", "startDate", "", "endDate", "getBpById", "id", "", "getBpList", "getFavoritBpList", "isFav", "", "getLastId", "searchBp", "query", "", "app_debug"})
@javax.inject.Singleton()
public abstract interface BpDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.BpEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM bp")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.BpEntity> getBpList();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM bp WHERE id = :id")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.BpEntity getBpById(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM bp Where isfavorit = :isFav ")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.BpEntity> getFavoritBpList(boolean isFav);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM bp ORDER BY id DESC LIMIT 1")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.BpEntity getLastId();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM bp WHERE name LIKE \'%\'|| :query || \'%\'")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.BpEntity> searchBp(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM bp WHERE created_at BETWEEN :startDate AND :endDate")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.BpEntity> getBpByDate(long startDate, long endDate);
}