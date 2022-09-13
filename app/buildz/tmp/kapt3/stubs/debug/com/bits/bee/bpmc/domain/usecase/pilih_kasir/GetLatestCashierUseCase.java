package com.bits.bee.bpmc.domain.usecase.pilih_kasir;

import java.lang.System;

/**
 * Created by aldi on 23/03/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ#\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\nH\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/pilih_kasir/GetLatestCashierUseCase;", "", "cashierRepository", "Lcom/bits/bee/bpmc/domain/repository/CashierRepository;", "branchDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/BranchDao;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/bits/bee/bpmc/domain/repository/CashierRepository;Lcom/bits/bee/bpmc/data/data_source/local/dao/BranchDao;Lkotlinx/coroutines/CoroutineDispatcher;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "", "Lcom/bits/bee/bpmc/domain/model/Cashier;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GetLatestCashierUseCase {
    private final com.bits.bee.bpmc.domain.repository.CashierRepository cashierRepository = null;
    private final com.bits.bee.bpmc.data.data_source.local.dao.BranchDao branchDao = null;
    private final kotlinx.coroutines.CoroutineDispatcher dispatcher = null;
    
    @javax.inject.Inject()
    public GetLatestCashierUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.CashierRepository cashierRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.BranchDao branchDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher dispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.bits.bee.bpmc.utils.Resource<? extends java.util.List<com.bits.bee.bpmc.domain.model.Cashier>>>> continuation) {
        return null;
    }
}