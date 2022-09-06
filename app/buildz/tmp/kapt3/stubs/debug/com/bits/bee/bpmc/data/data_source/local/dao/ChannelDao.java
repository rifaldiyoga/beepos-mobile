package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

/**
 * Created by aldi on 30/03/22.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\'J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\'\u00a8\u0006\b"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/ChannelDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/ChannelEntity;", "deleteAll", "", "getActiveChannelList", "", "getChannelList", "app_debug"})
public abstract interface ChannelDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.ChannelEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM channel")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.ChannelEntity> getChannelList();
    
    @androidx.room.Query(value = "DELETE FROM channel")
    public abstract void deleteAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM channel WHERE ispos = 1 AND active = 1")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.ChannelEntity> getActiveChannelList();
}