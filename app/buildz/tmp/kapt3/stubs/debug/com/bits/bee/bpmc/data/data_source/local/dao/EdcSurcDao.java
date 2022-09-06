package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

/**
 * Created by aldi on 07/06/22.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\'\u00a8\u0006\f"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/EdcSurcDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/EdcSurcEntity;", "getActiveEdcSurc", "", "Lcom/bits/bee/bpmc/data/data_source/local/model/EdcSurcWithCcTypeEntity;", "edcId", "", "type", "", "getEdcSurcByEdc", "getEdcSurcList", "app_debug"})
public abstract interface EdcSurcDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.EdcSurcEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT  * FROM edcsurc")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.EdcSurcEntity> getEdcSurcList();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM edcsurc WHERE edc_id = :edcId AND edcsurctype = :type")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.EdcSurcWithCcTypeEntity> getActiveEdcSurc(int edcId, @org.jetbrains.annotations.NotNull()
    java.lang.String type);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM edcsurc WHERE edc_id = :edcId ")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.EdcSurcEntity> getEdcSurcByEdc(int edcId);
}