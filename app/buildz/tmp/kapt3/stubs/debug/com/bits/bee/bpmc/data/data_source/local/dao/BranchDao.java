package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

/**
 * Created by aldi on 17/03/22.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\'J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\'J\b\u0010\t\u001a\u00020\nH\'\u00a8\u0006\u000b"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/BranchDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/BranchEntity;", "getActiveBranch", "getBranchById", "branchId", "", "getBranchList", "", "resetActive", "", "app_debug"})
@javax.inject.Singleton()
public abstract interface BranchDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.BranchEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM branch")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.BranchEntity> getBranchList();
    
    @androidx.room.Query(value = "UPDATE branch SET active = 0")
    public abstract void resetActive();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM branch WHERE active = 1 LIMIT 1")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.BranchEntity getActiveBranch();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM branch WHERE id = :branchId")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.BranchEntity getBranchById(int branchId);
}