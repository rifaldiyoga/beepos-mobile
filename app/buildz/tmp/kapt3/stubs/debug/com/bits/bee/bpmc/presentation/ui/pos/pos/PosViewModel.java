package com.bits.bee.bpmc.presentation.ui.pos.pos;

import java.lang.System;

/**
 * Created by aldi on 19/04/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/pos/PosViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/pos/pos/PosState;", "Lcom/bits/bee/bpmc/presentation/ui/pos/pos/PosViewModel$UIEvent;", "getActiveItemGroupUseCase", "Lcom/bits/bee/bpmc/domain/usecase/pos/GetActiveItemGroupUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/pos/GetActiveItemGroupUseCase;)V", "itemGroupList", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "", "Lcom/bits/bee/bpmc/domain/model/ItemGroup;", "getItemGroupList", "()Lkotlinx/coroutines/flow/Flow;", "setItemGroupList", "(Lkotlinx/coroutines/flow/Flow;)V", "onClickAdd", "Lkotlinx/coroutines/Job;", "onClickInvoice", "UIEvent", "app_debug"})
public final class PosViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.pos.pos.PosState, com.bits.bee.bpmc.presentation.ui.pos.pos.PosViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemGroupUseCase getActiveItemGroupUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.Flow<? extends com.bits.bee.bpmc.utils.Resource<? extends java.util.List<com.bits.bee.bpmc.domain.model.ItemGroup>>> itemGroupList;
    
    @javax.inject.Inject()
    public PosViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pos.GetActiveItemGroupUseCase getActiveItemGroupUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.ItemGroup>>> getItemGroupList() {
        return null;
    }
    
    public final void setItemGroupList(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<? extends com.bits.bee.bpmc.utils.Resource<? extends java.util.List<com.bits.bee.bpmc.domain.model.ItemGroup>>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickInvoice() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickAdd() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/pos/PosViewModel$UIEvent;", "", "()V", "NavigateToSearch", "RequestInvoice", "Lcom/bits/bee/bpmc/presentation/ui/pos/pos/PosViewModel$UIEvent$NavigateToSearch;", "Lcom/bits/bee/bpmc/presentation/ui/pos/pos/PosViewModel$UIEvent$RequestInvoice;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/pos/PosViewModel$UIEvent$RequestInvoice;", "Lcom/bits/bee/bpmc/presentation/ui/pos/pos/PosViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestInvoice extends com.bits.bee.bpmc.presentation.ui.pos.pos.PosViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pos.pos.PosViewModel.UIEvent.RequestInvoice INSTANCE = null;
            
            private RequestInvoice() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pos/pos/PosViewModel$UIEvent$NavigateToSearch;", "Lcom/bits/bee/bpmc/presentation/ui/pos/pos/PosViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToSearch extends com.bits.bee.bpmc.presentation.ui.pos.pos.PosViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pos.pos.PosViewModel.UIEvent.NavigateToSearch INSTANCE = null;
            
            private NavigateToSearch() {
                super();
            }
        }
    }
}