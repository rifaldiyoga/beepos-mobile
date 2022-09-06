package com.bits.bee.bpmc.presentation.ui.buka_kasir;

import java.lang.System;

/**
 * Created by aldi on 08/06/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/DetailBukaKasirViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/DetailBukaKasirState;", "Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/DetailBukaKasirViewModel$UIEvent;", "getActiveCashierUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveCashierUseCase;", "getActiveBranchUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveBranchUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveCashierUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveBranchUseCase;)V", "onBukaKasirClick", "Lkotlinx/coroutines/Job;", "onDoneSave", "saveBukaKasir", "UIEvent", "app_debug"})
public final class DetailBukaKasirViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.buka_kasir.DetailBukaKasirState, com.bits.bee.bpmc.presentation.ui.buka_kasir.DetailBukaKasirViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase getActiveCashierUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase getActiveBranchUseCase = null;
    
    @javax.inject.Inject()
    public DetailBukaKasirViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase getActiveCashierUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase getActiveBranchUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onBukaKasirClick() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job saveBukaKasir() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onDoneSave() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/DetailBukaKasirViewModel$UIEvent;", "", "()V", "NavigateToDefaultModal", "NavigateToPos", "RequestSave", "Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/DetailBukaKasirViewModel$UIEvent$NavigateToDefaultModal;", "Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/DetailBukaKasirViewModel$UIEvent$NavigateToPos;", "Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/DetailBukaKasirViewModel$UIEvent$RequestSave;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/DetailBukaKasirViewModel$UIEvent$NavigateToDefaultModal;", "Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/DetailBukaKasirViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToDefaultModal extends com.bits.bee.bpmc.presentation.ui.buka_kasir.DetailBukaKasirViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.buka_kasir.DetailBukaKasirViewModel.UIEvent.NavigateToDefaultModal INSTANCE = null;
            
            private NavigateToDefaultModal() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/DetailBukaKasirViewModel$UIEvent$NavigateToPos;", "Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/DetailBukaKasirViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToPos extends com.bits.bee.bpmc.presentation.ui.buka_kasir.DetailBukaKasirViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.buka_kasir.DetailBukaKasirViewModel.UIEvent.NavigateToPos INSTANCE = null;
            
            private NavigateToPos() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/DetailBukaKasirViewModel$UIEvent$RequestSave;", "Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/DetailBukaKasirViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestSave extends com.bits.bee.bpmc.presentation.ui.buka_kasir.DetailBukaKasirViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.buka_kasir.DetailBukaKasirViewModel.UIEvent.RequestSave INSTANCE = null;
            
            private RequestSave() {
                super();
            }
        }
    }
}