package com.bits.bee.bpmc.presentation.ui.transaksi_penjualan;

import java.lang.System;

/**
 * Created by aldi on 23/06/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0015\u0016B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/transaksi_penjualan/TransaksiPenjualanViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/transaksi_penjualan/TransaksiPenjualanState;", "Lcom/bits/bee/bpmc/presentation/ui/transaksi_penjualan/TransaksiPenjualanViewModel$UIEvent;", "getLatestSaleUseCase", "Lcom/bits/bee/bpmc/domain/usecase/transaksi_penjualan/GetLatestSaleUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/transaksi_penjualan/GetLatestSaleUseCase;)V", "currentQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "saleList", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/bits/bee/bpmc/domain/model/Sale;", "getSaleList$annotations", "()V", "getSaleList", "()Lkotlinx/coroutines/flow/Flow;", "onSearch", "Lkotlinx/coroutines/Job;", "query", "QueryWithSort", "UIEvent", "app_debug"})
public final class TransaksiPenjualanViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.transaksi_penjualan.TransaksiPenjualanState, com.bits.bee.bpmc.presentation.ui.transaksi_penjualan.TransaksiPenjualanViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.GetLatestSaleUseCase getLatestSaleUseCase = null;
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> currentQuery;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Sale>> saleList = null;
    
    @javax.inject.Inject()
    public TransaksiPenjualanViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.GetLatestSaleUseCase getLatestSaleUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Sale>> getSaleList() {
        return null;
    }
    
    @kotlinx.coroutines.ExperimentalCoroutinesApi()
    @java.lang.Deprecated()
    public static void getSaleList$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/transaksi_penjualan/TransaksiPenjualanViewModel$UIEvent;", "", "()V", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/transaksi_penjualan/TransaksiPenjualanViewModel$QueryWithSort;", "", "query", "", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class QueryWithSort {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String query = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.presentation.ui.transaksi_penjualan.TransaksiPenjualanViewModel.QueryWithSort copy(@org.jetbrains.annotations.NotNull()
        java.lang.String query) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        public QueryWithSort(@org.jetbrains.annotations.NotNull()
        java.lang.String query) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getQuery() {
            return null;
        }
    }
}