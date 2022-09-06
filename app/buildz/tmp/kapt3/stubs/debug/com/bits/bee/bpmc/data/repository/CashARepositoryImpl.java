package com.bits.bee.bpmc.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00130\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/bits/bee/bpmc/data/repository/CashARepositoryImpl;", "Lcom/bits/bee/bpmc/domain/repository/CashARepository;", "cashADao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CashADao;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/bits/bee/bpmc/data/data_source/local/dao/CashADao;Lkotlinx/coroutines/CoroutineDispatcher;)V", "addCashA", "", "cashAEntity", "Lcom/bits/bee/bpmc/data/data_source/local/model/CashAEntity;", "(Lcom/bits/bee/bpmc/data/data_source/local/model/CashAEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCashAByCash", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/bits/bee/bpmc/domain/model/CashA;", "cashId", "", "getLastCasha", "Lcom/bits/bee/bpmc/utils/Resource;", "app_debug"})
public final class CashARepositoryImpl implements com.bits.bee.bpmc.domain.repository.CashARepository {
    private final com.bits.bee.bpmc.data.data_source.local.dao.CashADao cashADao = null;
    private final kotlinx.coroutines.CoroutineDispatcher defaultDispatcher = null;
    
    @javax.inject.Inject()
    public CashARepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CashADao cashADao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object addCashA(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.model.CashAEntity cashAEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.CashA>>> getLastCasha() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.bits.bee.bpmc.domain.model.CashA>> getCashAByCash(int cashId) {
        return null;
    }
}