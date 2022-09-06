package com.bits.bee.bpmc.data.repository;

import java.lang.System;

/**
 * Created by aldi on 20/07/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/bits/bee/bpmc/data/repository/SaleCrcvRepositoryImpl;", "Lcom/bits/bee/bpmc/domain/repository/SaleCrcvRepository;", "saleCrcvDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleCrcvDao;", "defDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleCrcvDao;Lkotlinx/coroutines/CoroutineDispatcher;)V", "addSaleCrcv", "", "saleCrcv", "Lcom/bits/bee/bpmc/domain/model/SaleCrcv;", "(Lcom/bits/bee/bpmc/domain/model/SaleCrcv;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SaleCrcvRepositoryImpl implements com.bits.bee.bpmc.domain.repository.SaleCrcvRepository {
    private final com.bits.bee.bpmc.data.data_source.local.dao.SaleCrcvDao saleCrcvDao = null;
    private final kotlinx.coroutines.CoroutineDispatcher defDispatcher = null;
    
    @javax.inject.Inject()
    public SaleCrcvRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.SaleCrcvDao saleCrcvDao, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object addSaleCrcv(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.SaleCrcv saleCrcv, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}