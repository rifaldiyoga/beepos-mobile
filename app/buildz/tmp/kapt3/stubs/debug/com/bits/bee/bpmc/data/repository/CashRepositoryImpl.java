package com.bits.bee.bpmc.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/bits/bee/bpmc/data/repository/CashRepositoryImpl;", "Lcom/bits/bee/bpmc/domain/repository/CashRepository;", "cashDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CashDao;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/bits/bee/bpmc/data/data_source/local/dao/CashDao;Lkotlinx/coroutines/CoroutineDispatcher;)V", "addCash", "", "cashEntity", "Lcom/bits/bee/bpmc/data/data_source/local/model/CashEntity;", "(Lcom/bits/bee/bpmc/data/data_source/local/model/CashEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastId", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/domain/model/Cash;", "app_debug"})
public final class CashRepositoryImpl implements com.bits.bee.bpmc.domain.repository.CashRepository {
    private final com.bits.bee.bpmc.data.data_source.local.dao.CashDao cashDao = null;
    private final kotlinx.coroutines.CoroutineDispatcher defaultDispatcher = null;
    
    @javax.inject.Inject()
    public CashRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CashDao cashDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object addCash(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.model.CashEntity cashEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.domain.model.Cash> getLastId() {
        return null;
    }
}