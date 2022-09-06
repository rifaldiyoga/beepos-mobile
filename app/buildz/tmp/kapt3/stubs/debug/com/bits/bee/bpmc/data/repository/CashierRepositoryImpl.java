package com.bits.bee.bpmc.data.repository;

import java.lang.System;

/**
 * Created by aldi on 17/03/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0016J\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\r0\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00110\r0\n2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/bits/bee/bpmc/data/repository/CashierRepositoryImpl;", "Lcom/bits/bee/bpmc/domain/repository/CashierRepository;", "apiUtils", "Lcom/bits/bee/bpmc/data/data_source/remote/ApiUtils;", "cashierDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/CashierDao;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/bits/bee/bpmc/data/data_source/remote/ApiUtils;Lcom/bits/bee/bpmc/data/data_source/local/dao/CashierDao;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getActiveCashier", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/domain/model/Cashier;", "getCashierById", "Lcom/bits/bee/bpmc/utils/Resource;", "id", "", "getCashierList", "", "branchId", "updateActiveCashier", "", "cashier", "(Lcom/bits/bee/bpmc/domain/model/Cashier;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CashierRepositoryImpl implements com.bits.bee.bpmc.domain.repository.CashierRepository {
    private final com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils = null;
    private final com.bits.bee.bpmc.data.data_source.local.dao.CashierDao cashierDao = null;
    private final kotlinx.coroutines.CoroutineDispatcher defaultDispatcher = null;
    
    @javax.inject.Inject()
    public CashierRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.remote.ApiUtils apiUtils, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.CashierDao cashierDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Cashier>>> getCashierList(int branchId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object updateActiveCashier(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Cashier cashier, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.domain.model.Cashier> getActiveCashier() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.domain.model.Cashier>> getCashierById(int id) {
        return null;
    }
}