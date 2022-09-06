package com.bits.bee.bpmc.domain.repository;

import java.lang.System;

/**
 * Created by aldi on 20/05/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH&J$\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\"\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u00130\n2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\n2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\n2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\n2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\n2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\n2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\n2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0019\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/bits/bee/bpmc/domain/repository/SaleRepository;", "", "addSale", "", "sale", "Lcom/bits/bee/bpmc/domain/model/Sale;", "(Lcom/bits/bee/bpmc/domain/model/Sale;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSale", "", "getLatestDraftList", "Lkotlinx/coroutines/flow/Flow;", "", "getLatestSaleList", "Landroidx/paging/PagingData;", "query", "", "isDraft", "", "getSaleByPosses", "Lcom/bits/bee/bpmc/utils/Resource;", "id", "", "getTotalNota", "Ljava/math/BigDecimal;", "getTotalNotaVoid", "getTotalPaidDebit", "getTotalPaidGopay", "getTotalPaidKredit", "getTotalPaidTunai", "updateSale", "app_debug"})
public abstract interface SaleRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addSale(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSale(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSale(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Sale>> getLatestSaleList(@org.jetbrains.annotations.NotNull()
    java.lang.String query, boolean isDraft);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.bits.bee.bpmc.domain.model.Sale>> getLatestDraftList();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Sale>>> getSaleByPosses(int id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.math.BigDecimal> getTotalNota(int id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.math.BigDecimal> getTotalNotaVoid(int id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.math.BigDecimal> getTotalPaidTunai(int id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.math.BigDecimal> getTotalPaidDebit(int id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.math.BigDecimal> getTotalPaidKredit(int id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.math.BigDecimal> getTotalPaidGopay(int id);
}