package com.bits.bee.bpmc.data.repository;

import java.lang.System;

/**
 * Created by aldi on 30/03/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0016J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\n2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u001a\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00100\nH\u0016J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/bits/bee/bpmc/data/repository/CityRepositoryImpl;", "Lcom/bits/bee/bpmc/domain/repository/CityRepository;", "apiUtils", "Lcom/bits/bee/bpmc/data/data_source/remote/ApiUtils;", "cityDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CityDao;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/bits/bee/bpmc/data/data_source/remote/ApiUtils;Lcom/bits/bee/bpmc/data/data_source/local/dao/CityDao;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getActiveCityList", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/bits/bee/bpmc/domain/model/City;", "getCityDao", "", "getCodeByName", "Lcom/bits/bee/bpmc/utils/Resource;", "str", "getLatestCityList", "searchCityList", "query", "app_debug"})
public final class CityRepositoryImpl implements com.bits.bee.bpmc.domain.repository.CityRepository {
    private final com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils = null;
    private final com.bits.bee.bpmc.data.data_source.local.dao.CityDao cityDao = null;
    private final kotlinx.coroutines.CoroutineDispatcher defaultDispatcher = null;
    
    @javax.inject.Inject()
    public CityRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CityDao cityDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.City>>> getLatestCityList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.bits.bee.bpmc.domain.model.City>> getActiveCityList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.bits.bee.bpmc.domain.model.City>> searchCityList(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.domain.model.City>> getCodeByName(@org.jetbrains.annotations.NotNull()
    java.lang.String str) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getCityDao() {
        return null;
    }
}