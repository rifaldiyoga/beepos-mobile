package com.bits.bee.bpmc.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0016J\u001a\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f0\t0\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/bits/bee/bpmc/data/repository/KitchenRepositoryImpl;", "Lcom/bits/bee/bpmc/domain/repository/KitchenRepository;", "kitchenDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/KitchenDao;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/bits/bee/bpmc/data/data_source/local/dao/KitchenDao;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getKitchenId", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "Lcom/bits/bee/bpmc/domain/model/Kitchen;", "id", "", "getLastKitchen", "readKitchen", "", "app_debug"})
public final class KitchenRepositoryImpl implements com.bits.bee.bpmc.domain.repository.KitchenRepository {
    private final com.bits.bee.bpmc.data.data_source.local.dao.KitchenDao kitchenDao = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    
    @javax.inject.Inject()
    public KitchenRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.KitchenDao kitchenDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.domain.model.Kitchen>> getKitchenId(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.domain.model.Kitchen>> getLastKitchen() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Kitchen>>> readKitchen() {
        return null;
    }
}