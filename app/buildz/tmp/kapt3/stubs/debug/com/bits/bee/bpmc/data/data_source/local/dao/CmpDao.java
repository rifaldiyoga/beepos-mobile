package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\'J\b\u0010\u0005\u001a\u00020\u0002H\'\u00a8\u0006\u0006"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/CmpDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/CmpEntity;", "deleteAll", "", "getCmp", "app_debug"})
public abstract interface CmpDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.CmpEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM cmp")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.CmpEntity getCmp();
    
    @androidx.room.Query(value = "DELETE FROM cmp")
    public abstract void deleteAll();
}