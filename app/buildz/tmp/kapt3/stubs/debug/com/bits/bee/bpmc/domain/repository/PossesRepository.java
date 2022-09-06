package com.bits.bee.bpmc.domain.repository;

import java.lang.System;

/**
 * Created by aldi on 07/06/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J1\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J#\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00130\u00120\u000eH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J*\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00130\u00120\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H&J*\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00130\u00120\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H&J*\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00130\u00120\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H&J*\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00130\u00120\u000e2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0016H&J\u001a\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00130\u00120\u000eH&J\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001f0\u000eH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001c\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00120\u000e2\u0006\u0010!\u001a\u00020\u0007H&J\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001f0\u000eH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001a\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00130\u00120\u000eH&J\u001a\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00130\u00120\u000eH&J\u0019\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u000fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006("}, d2 = {"Lcom/bits/bee/bpmc/domain/repository/PossesRepository;", "", "addPosses", "", "startBal", "Ljava/math/BigDecimal;", "shift", "", "branch", "Lcom/bits/bee/bpmc/domain/model/Branch;", "cashier", "Lcom/bits/bee/bpmc/domain/model/Cashier;", "(Ljava/math/BigDecimal;ILcom/bits/bee/bpmc/domain/model/Branch;Lcom/bits/bee/bpmc/domain/model/Cashier;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActivePosses", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/domain/model/Posses;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActivePossesList", "Lcom/bits/bee/bpmc/utils/Resource;", "", "getFilter", "current", "", "end", "getFilterAsc", "getFilterDesc", "getJmlPossesByDate", "startDate", "endDate", "getListPossesHistory", "getPosses", "Landroidx/paging/PagingData;", "getPossesById", "id", "getPossesHistory", "getSortAsc", "getSortDesc", "updatePosses", "posses", "(Lcom/bits/bee/bpmc/domain/model/Posses;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface PossesRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getActivePosses(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.domain.model.Posses>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPosses(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Posses>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addPosses(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal startBal, int shift, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Branch branch, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Cashier cashier, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updatePosses(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Posses posses, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.domain.model.Posses>> getPossesById(int id);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPossesHistory(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Posses>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getActivePossesList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.bits.bee.bpmc.utils.Resource<? extends java.util.List<com.bits.bee.bpmc.domain.model.Posses>>>> continuation);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Posses>>> getSortDesc();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Posses>>> getSortAsc();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Posses>>> getFilter(long current, long end);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Posses>>> getListPossesHistory();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Posses>>> getJmlPossesByDate(long startDate, long endDate);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Posses>>> getFilterAsc(long current, long end);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Posses>>> getFilterDesc(long current, long end);
}