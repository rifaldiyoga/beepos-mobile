package com.bits.bee.bpmc.data.repository;

import java.lang.System;

/**
 * Created by aldi on 20/05/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/bits/bee/bpmc/data/repository/SaleAddOnRepositoryImpl;", "Lcom/bits/bee/bpmc/domain/repository/SaleAddOnRepository;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "saleAddOnDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleAddOnDao;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleAddOnDao;)V", "addSaleAddOn", "", "saleAddOn", "Lcom/bits/bee/bpmc/domain/model/SaleAddOn;", "(Lcom/bits/bee/bpmc/domain/model/SaleAddOn;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SaleAddOnRepositoryImpl implements com.bits.bee.bpmc.domain.repository.SaleAddOnRepository {
    private final kotlinx.coroutines.CoroutineDispatcher defaultDispatcher = null;
    private final com.bits.bee.bpmc.data.data_source.local.dao.SaleAddOnDao saleAddOnDao = null;
    
    @javax.inject.Inject()
    public SaleAddOnRepositoryImpl(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.SaleAddOnDao saleAddOnDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object addSaleAddOn(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.SaleAddOn saleAddOn, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}