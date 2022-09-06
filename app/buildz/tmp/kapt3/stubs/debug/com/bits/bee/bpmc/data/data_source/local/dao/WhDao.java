package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

/**
 * Created by aldi on 20/05/22.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\'\u00a8\u0006\b"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/WhDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/WhEntity;", "getWhById", "whId", "", "getWhList", "", "app_debug"})
public abstract interface WhDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.WhEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM wh")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.WhEntity> getWhList();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM wh WHERE id = :whId")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.WhEntity getWhById(int whId);
}