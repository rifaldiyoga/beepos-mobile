package com.bits.bee.bpmc.presentation.ui.pos.draft;

import java.lang.System;

/**
 * Created by aldi on 27/06/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001b\u001cB\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r8\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/draft/DraftViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/pos/draft/DraftState;", "Lcom/bits/bee/bpmc/presentation/ui/pos/draft/DraftViewModel$UIEvent;", "getLatestSaleUseCase", "Lcom/bits/bee/bpmc/domain/usecase/transaksi_penjualan/GetLatestSaleUseCase;", "deleteSaleUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/DeleteSaleUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/transaksi_penjualan/GetLatestSaleUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/DeleteSaleUseCase;)V", "currentQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "draftList", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/bits/bee/bpmc/domain/model/Sale;", "getDraftList$annotations", "()V", "getDraftList", "()Lkotlinx/coroutines/flow/Flow;", "onDeleteClick", "Lkotlinx/coroutines/Job;", "sale", "onItemClick", "onSearch", "", "query", "QueryWithSort", "UIEvent", "app_debug"})
public final class DraftViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.pos.draft.DraftState, com.bits.bee.bpmc.presentation.ui.pos.draft.DraftViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.GetLatestSaleUseCase getLatestSaleUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.DeleteSaleUseCase deleteSaleUseCase = null;
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> currentQuery;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Sale>> draftList = null;
    
    @javax.inject.Inject()
    public DraftViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.GetLatestSaleUseCase getLatestSaleUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.DeleteSaleUseCase deleteSaleUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Sale>> getDraftList() {
        return null;
    }
    
    @kotlinx.coroutines.ExperimentalCoroutinesApi()
    @java.lang.Deprecated()
    public static void getDraftList$annotations() {
    }
    
    public final void onSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onItemClick(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onDeleteClick(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/draft/DraftViewModel$UIEvent;", "", "()V", "RequestDraft", "Lcom/bits/bee/bpmc/presentation/ui/pos/draft/DraftViewModel$UIEvent$RequestDraft;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/draft/DraftViewModel$UIEvent$RequestDraft;", "Lcom/bits/bee/bpmc/presentation/ui/pos/draft/DraftViewModel$UIEvent;", "sale", "Lcom/bits/bee/bpmc/domain/model/Sale;", "(Lcom/bits/bee/bpmc/domain/model/Sale;)V", "getSale", "()Lcom/bits/bee/bpmc/domain/model/Sale;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class RequestDraft extends com.bits.bee.bpmc.presentation.ui.pos.draft.DraftViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            private final com.bits.bee.bpmc.domain.model.Sale sale = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.presentation.ui.pos.draft.DraftViewModel.UIEvent.RequestDraft copy(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Sale sale) {
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
            
            public RequestDraft(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Sale sale) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Sale component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Sale getSale() {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/draft/DraftViewModel$QueryWithSort;", "", "query", "", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class QueryWithSort {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String query = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.bits.bee.bpmc.presentation.ui.pos.draft.DraftViewModel.QueryWithSort copy(@org.jetbrains.annotations.NotNull()
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