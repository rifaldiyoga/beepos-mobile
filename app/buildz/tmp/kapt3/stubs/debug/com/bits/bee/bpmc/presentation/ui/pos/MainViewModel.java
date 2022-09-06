package com.bits.bee.bpmc.presentation.ui.pos;

import java.lang.System;

/**
 * Created by aldi on 21/04/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001>BG\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u000e\u0010\'\u001a\u00020%2\u0006\u0010(\u001a\u00020)J\u001e\u0010*\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010#2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020#0-J\u0018\u0010.\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020%J\u0006\u00102\u001a\u00020%J\u0006\u00103\u001a\u00020%J\u0006\u00104\u001a\u00020%J\u0006\u00105\u001a\u00020%J\u0006\u00106\u001a\u00020%J\u000e\u00107\u001a\u00020%2\u0006\u00108\u001a\u000209J\u000e\u0010:\u001a\u00020%2\u0006\u00108\u001a\u000209J\u000e\u0010;\u001a\u00020!2\u0006\u0010\"\u001a\u00020<J\u0006\u0010=\u001a\u00020!R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006?"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainState;", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent;", "getActiveChannelUseCase", "Lcom/bits/bee/bpmc/domain/usecase/pos/GetActiveChannelUseCase;", "getActivePossesUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActivePossesUseCase;", "getActiveCashierUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveCashierUseCase;", "getActiveBranchUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveBranchUseCase;", "getDefaultBpUseCase", "Lcom/bits/bee/bpmc/domain/usecase/pos/GetDefaultBpUseCase;", "getDefaultCrcUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetDefaultCrcUseCase;", "getSaledListUseCase", "Lcom/bits/bee/bpmc/domain/usecase/transaksi_penjualan/GetSaledListUseCase;", "getItemGroupAddOnUseCase", "Lcom/bits/bee/bpmc/domain/usecase/pos/GetItemGroupAddOnUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/pos/GetActiveChannelUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/GetActivePossesUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveCashierUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveBranchUseCase;Lcom/bits/bee/bpmc/domain/usecase/pos/GetDefaultBpUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/GetDefaultCrcUseCase;Lcom/bits/bee/bpmc/domain/usecase/transaksi_penjualan/GetSaledListUseCase;Lcom/bits/bee/bpmc/domain/usecase/pos/GetItemGroupAddOnUseCase;)V", "_posModeState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bits/bee/bpmc/presentation/ui/pos/PosModeState;", "_saleTrans", "Lcom/bits/bee/bpmc/domain/trans/SaleTrans;", "posModeState", "getPosModeState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "saleTrans", "getSaleTrans", "()Lcom/bits/bee/bpmc/domain/trans/SaleTrans;", "addAddOn", "", "item", "Lcom/bits/bee/bpmc/domain/model/ItemWithUnit;", "deployData", "Lkotlinx/coroutines/Job;", "loadData", "loadDraft", "sale", "Lcom/bits/bee/bpmc/domain/model/Sale;", "onAddAddOn", "variant", "addOnList", "", "onAddDetail", "useItemqty", "", "onClickChannel", "onClickDiskonNota", "onClickDraft", "onClickMember", "onClickPromo", "onClickSearch", "onDeleteDetail", "saled", "Lcom/bits/bee/bpmc/domain/model/Saled;", "onEditDetail", "onMinusClick", "Lcom/bits/bee/bpmc/domain/model/Item;", "resetState", "UIEvent", "app_debug"})
public final class MainViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.pos.MainState, com.bits.bee.bpmc.presentation.ui.pos.MainViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.pos.GetActiveChannelUseCase getActiveChannelUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase getActivePossesUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase getActiveCashierUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase getActiveBranchUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.pos.GetDefaultBpUseCase getDefaultBpUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetDefaultCrcUseCase getDefaultCrcUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.GetSaledListUseCase getSaledListUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.pos.GetItemGroupAddOnUseCase getItemGroupAddOnUseCase = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.bits.bee.bpmc.presentation.ui.pos.PosModeState> _posModeState = null;
    private final com.bits.bee.bpmc.domain.trans.SaleTrans _saleTrans = null;
    @org.jetbrains.annotations.NotNull()
    private final com.bits.bee.bpmc.domain.trans.SaleTrans saleTrans = null;
    
    @javax.inject.Inject()
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pos.GetActiveChannelUseCase getActiveChannelUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase getActivePossesUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase getActiveCashierUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase getActiveBranchUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pos.GetDefaultBpUseCase getDefaultBpUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetDefaultCrcUseCase getDefaultCrcUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.GetSaledListUseCase getSaledListUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pos.GetItemGroupAddOnUseCase getItemGroupAddOnUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<com.bits.bee.bpmc.presentation.ui.pos.PosModeState> getPosModeState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bits.bee.bpmc.domain.trans.SaleTrans getSaleTrans() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadDraft(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickDraft() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickDiskonNota() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickSearch() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickMember() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickChannel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickPromo() {
        return null;
    }
    
    public final void onAddDetail(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.ItemWithUnit item, boolean useItemqty) {
    }
    
    public final void onAddAddOn(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.ItemWithUnit variant, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.ItemWithUnit> addOnList) {
    }
    
    public final void addAddOn(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.ItemWithUnit item) {
    }
    
    public final void onMinusClick(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Item item) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onDeleteDetail(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Saled saled) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onEditDetail(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Saled saled) {
        return null;
    }
    
    public final void resetState() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deployData() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent;", "", "()V", "NavigateToDiskonNota", "NavigateToDraft", "NavigateToPromo", "NavigateToSearch", "RequestChannel", "RequestMember", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent$NavigateToDiskonNota;", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent$NavigateToDraft;", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent$NavigateToPromo;", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent$NavigateToSearch;", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent$RequestChannel;", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent$RequestMember;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent$RequestMember;", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestMember extends com.bits.bee.bpmc.presentation.ui.pos.MainViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pos.MainViewModel.UIEvent.RequestMember INSTANCE = null;
            
            private RequestMember() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent$RequestChannel;", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestChannel extends com.bits.bee.bpmc.presentation.ui.pos.MainViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pos.MainViewModel.UIEvent.RequestChannel INSTANCE = null;
            
            private RequestChannel() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent$NavigateToDraft;", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToDraft extends com.bits.bee.bpmc.presentation.ui.pos.MainViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pos.MainViewModel.UIEvent.NavigateToDraft INSTANCE = null;
            
            private NavigateToDraft() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent$NavigateToDiskonNota;", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToDiskonNota extends com.bits.bee.bpmc.presentation.ui.pos.MainViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pos.MainViewModel.UIEvent.NavigateToDiskonNota INSTANCE = null;
            
            private NavigateToDiskonNota() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent$NavigateToPromo;", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToPromo extends com.bits.bee.bpmc.presentation.ui.pos.MainViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pos.MainViewModel.UIEvent.NavigateToPromo INSTANCE = null;
            
            private NavigateToPromo() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent$NavigateToSearch;", "Lcom/bits/bee/bpmc/presentation/ui/pos/MainViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToSearch extends com.bits.bee.bpmc.presentation.ui.pos.MainViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pos.MainViewModel.UIEvent.NavigateToSearch INSTANCE = null;
            
            private NavigateToSearch() {
                super();
            }
        }
    }
}