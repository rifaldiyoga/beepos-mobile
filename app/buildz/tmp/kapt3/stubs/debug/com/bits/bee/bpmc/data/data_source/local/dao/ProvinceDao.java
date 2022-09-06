package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\'\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/ProvinceDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/ProvinceEntity;", "getProvinceList", "", "app_debug"})
@javax.inject.Singleton()
public abstract interface ProvinceDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.ProvinceEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM province")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.ProvinceEntity> getProvinceList();
}