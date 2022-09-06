package com.bits.bee.bpmc.data.repository;

import java.lang.System;

/**
 * Created by aldi on 20/05/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00100\u000fH\u0016J$\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00120\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00100\u00180\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0019\u0010\"\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/bits/bee/bpmc/data/repository/SaleRepositoryImpl;", "Lcom/bits/bee/bpmc/domain/repository/SaleRepository;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "saleDao", "Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleDao;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/bits/bee/bpmc/data/data_source/local/dao/SaleDao;)V", "addSale", "", "sale", "Lcom/bits/bee/bpmc/domain/model/Sale;", "(Lcom/bits/bee/bpmc/domain/model/Sale;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSale", "", "getLatestDraftList", "Lkotlinx/coroutines/flow/Flow;", "", "getLatestSaleList", "Landroidx/paging/PagingData;", "query", "", "isDraft", "", "getSaleByPosses", "Lcom/bits/bee/bpmc/utils/Resource;", "id", "", "getTotalNota", "Ljava/math/BigDecimal;", "getTotalNotaVoid", "getTotalPaidDebit", "getTotalPaidGopay", "getTotalPaidKredit", "getTotalPaidTunai", "updateSale", "app_debug"})
public final class SaleRepositoryImpl implements com.bits.bee.bpmc.domain.repository.SaleRepository {
    private final kotlinx.coroutines.CoroutineDispatcher defaultDispatcher = null;
    private final com.bits.bee.bpmc.data.data_source.local.dao.SaleDao saleDao = null;
    
    @javax.inject.Inject()
    public SaleRepositoryImpl(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.dao.SaleDao saleDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object addSale(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object deleteSale(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object updateSale(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Sale>> getLatestSaleList(@org.jetbrains.annotations.NotNull()
    java.lang.String query, boolean isDraft) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.bits.bee.bpmc.domain.model.Sale>> getLatestDraftList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Sale>>> getSaleByPosses(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.math.BigDecimal> getTotalNota(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.math.BigDecimal> getTotalNotaVoid(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.math.BigDecimal> getTotalPaidTunai(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.math.BigDecimal> getTotalPaidDebit(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.math.BigDecimal> getTotalPaidKredit(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.math.BigDecimal> getTotalPaidGopay(int id) {
        return null;
    }
}