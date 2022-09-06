package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

/**
 * Created by aldi on 07/06/22.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\'J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\'J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\'J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\'J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\'J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\'J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020\u0010H\'J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\'J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\'J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020\u0010H\'J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\'J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\'J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\'\u00a8\u0006\u001b"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/PossesDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/PossesEntity;", "getActivePosses", "getActivePossesList", "", "getFilter", "current", "", "end", "getFilterAsc", "getFilterDesc", "getJmlPossesByDate", "startDate", "endDate", "getListPosses", "Landroidx/paging/PagingSource;", "", "getListPossesHistory", "getPossesById", "id", "getPossesHistory", "getSortAsc", "getSortDesc", "searchSesi", "query", "", "app_debug"})
public abstract interface PossesDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.PossesEntity> {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM posses WHERE endbal is null")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.PossesEntity getActivePosses();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM posses WHERE endbal is null")
    public abstract androidx.paging.PagingSource<java.lang.Integer, com.bits.bee.bpmc.data.data_source.local.model.PossesEntity> getListPosses();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM posses WHERE id = :id")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.PossesEntity getPossesById(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM posses WHERE endbal is not null")
    public abstract androidx.paging.PagingSource<java.lang.Integer, com.bits.bee.bpmc.data.data_source.local.model.PossesEntity> getPossesHistory();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM posses WHERE endbal is null")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.PossesEntity> getActivePossesList();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM posses WHERE shift LIKE \'%\'|| :query || \'%\'")
    public abstract androidx.paging.PagingSource<java.lang.Integer, com.bits.bee.bpmc.data.data_source.local.model.PossesEntity> searchSesi(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM posses WHERE endbal is not null ORDER BY id DESC")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.PossesEntity> getSortDesc();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM posses WHERE endbal is not null ORDER BY id ASC")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.PossesEntity> getSortAsc();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM posses WHERE trxdate BETWEEN :current AND :end")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.PossesEntity> getFilter(long current, long end);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM posses WHERE endbal is not null and trxdate between :startDate and :endDate")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.PossesEntity> getJmlPossesByDate(long startDate, long endDate);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM posses WHERE endbal is not null")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.PossesEntity> getListPossesHistory();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM posses WHERE endbal is not null and trxdate BETWEEN :current AND :end ORDER BY id asc")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.PossesEntity> getFilterAsc(long current, long end);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM posses WHERE endbal is not null and trxdate BETWEEN :current AND :end ORDER BY id desc")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.PossesEntity> getFilterDesc(long current, long end);
}