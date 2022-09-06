package com.bits.bee.bpmc.data.repository;

import java.lang.System;

/**
 * Created by aldi on 09/05/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/bits/bee/bpmc/data/repository/BpAddrRepositoryImpl;", "Lcom/bits/bee/bpmc/domain/repository/BpAddrRepository;", "bpAddrDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/BpAddrDao;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/bits/bee/bpmc/data/data_source/local/dao/BpAddrDao;Lkotlinx/coroutines/CoroutineDispatcher;)V", "addUpdateBpAddr", "", "bpaddr", "Lcom/bits/bee/bpmc/data/data_source/local/model/BpAddrEntity;", "(Lcom/bits/bee/bpmc/data/data_source/local/model/BpAddrEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBpAddrByBp", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "Lcom/bits/bee/bpmc/domain/model/BpAddr;", "id", "", "app_debug"})
public final class BpAddrRepositoryImpl implements com.bits.bee.bpmc.domain.repository.BpAddrRepository {
    private final com.bits.bee.bpmc.data.data_source.local.dao.BpAddrDao bpAddrDao = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    
    @javax.inject.Inject()
    public BpAddrRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.BpAddrDao bpAddrDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object addUpdateBpAddr(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.model.BpAddrEntity bpaddr, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.domain.model.BpAddr>> getBpAddrByBp(int id) {
        return null;
    }
}