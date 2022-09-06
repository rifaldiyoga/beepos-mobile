package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

/**
 * Created by aldi on 23/03/22.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\'J\b\u0010\u0005\u001a\u00020\u0002H\'J\b\u0010\u0006\u001a\u00020\u0002H\'J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\'\u00a8\u0006\n"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/UserDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/UserEntity;", "deleteAll", "", "geActiveUser", "getDefaultUser", "getUserById", "id", "", "app_debug"})
public abstract interface UserDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.UserEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM user WHERE active = 1")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.UserEntity geActiveUser();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM user WHERE id = 3")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.UserEntity getDefaultUser();
    
    @androidx.room.Query(value = "DELETE FROM user")
    public abstract void deleteAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM user WHERE id = :id")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.UserEntity getUserById(int id);
}