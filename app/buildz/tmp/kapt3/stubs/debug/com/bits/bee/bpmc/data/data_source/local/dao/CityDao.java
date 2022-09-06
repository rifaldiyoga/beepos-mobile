package com.bits.bee.bpmc.data.data_source.local.dao;

import java.lang.System;

/**
 * Created by aldi on 30/03/22.
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\'J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\'J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\tH\'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\r\u001a\u00020\tH\'\u00a8\u0006\u000e"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/local/dao/CityDao;", "Lcom/bits/bee/bpmc/data/data_source/local/base/BaseDao;", "Lcom/bits/bee/bpmc/data/data_source/local/model/CityEntity;", "deleteAll", "", "getActiveCityList", "", "getCityList", "getCityName", "", "getCodeByName", "name", "searchCityList", "query", "app_debug"})
public abstract interface CityDao extends com.bits.bee.bpmc.data.data_source.local.base.BaseDao<com.bits.bee.bpmc.data.data_source.local.model.CityEntity> {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM city")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.CityEntity> getCityList();
    
    @androidx.room.Query(value = "DELETE FROM city")
    public abstract void deleteAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM city")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.CityEntity> getActiveCityList();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM city WHERE name LIKE \'%\'|| :query || \'%\'")
    public abstract java.util.List<com.bits.bee.bpmc.data.data_source.local.model.CityEntity> searchCityList(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT name FROM city ")
    public abstract java.util.List<java.lang.String> getCityName();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM city where name = :name")
    public abstract com.bits.bee.bpmc.data.data_source.local.model.CityEntity getCodeByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
}