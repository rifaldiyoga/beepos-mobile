package com.bits.bee.bpmc.presentation.ui.beranda;

import java.lang.System;

/**
 * Created by aldi on 03/06/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0016R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/beranda/BerandaViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/beranda/BerandaState;", "Lcom/bits/bee/bpmc/presentation/ui/beranda/BerandaViewModel$UIEvent;", "getActiveBranchUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveBranchUseCase;", "getActiveCashierUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveCashierUseCase;", "getActivePossesUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActivePossesUseCase;", "tutupKasirUseCase", "Lcom/bits/bee/bpmc/domain/usecase/tutup_kasir/TutupKasirUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveBranchUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveCashierUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/GetActivePossesUseCase;Lcom/bits/bee/bpmc/domain/usecase/tutup_kasir/TutupKasirUseCase;)V", "getActiveBranch", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/domain/model/Branch;", "getGetActiveBranch", "()Lkotlinx/coroutines/flow/Flow;", "getActiveCashier", "Lcom/bits/bee/bpmc/domain/model/Cashier;", "getGetActiveCashier", "onBukaKasirClick", "Lkotlinx/coroutines/Job;", "onDetailBukaKasirClick", "onDetailTutupKasirClick", "UIEvent", "app_debug"})
public final class BerandaViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.beranda.BerandaState, com.bits.bee.bpmc.presentation.ui.beranda.BerandaViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase getActiveBranchUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase getActiveCashierUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase getActivePossesUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.tutup_kasir.TutupKasirUseCase tutupKasirUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.domain.model.Cashier> getActiveCashier = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.domain.model.Branch> getActiveBranch = null;
    
    @javax.inject.Inject()
    public BerandaViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase getActiveBranchUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase getActiveCashierUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase getActivePossesUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.tutup_kasir.TutupKasirUseCase tutupKasirUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.domain.model.Cashier> getGetActiveCashier() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.domain.model.Branch> getGetActiveBranch() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onDetailBukaKasirClick() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onDetailTutupKasirClick() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onBukaKasirClick() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/beranda/BerandaViewModel$UIEvent;", "", "()V", "NavigateToBukaKasir", "NavigateToDialogBukaKasir", "NavigateToTutupKasir", "Lcom/bits/bee/bpmc/presentation/ui/beranda/BerandaViewModel$UIEvent$NavigateToBukaKasir;", "Lcom/bits/bee/bpmc/presentation/ui/beranda/BerandaViewModel$UIEvent$NavigateToDialogBukaKasir;", "Lcom/bits/bee/bpmc/presentation/ui/beranda/BerandaViewModel$UIEvent$NavigateToTutupKasir;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/beranda/BerandaViewModel$UIEvent$NavigateToBukaKasir;", "Lcom/bits/bee/bpmc/presentation/ui/beranda/BerandaViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToBukaKasir extends com.bits.bee.bpmc.presentation.ui.beranda.BerandaViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.beranda.BerandaViewModel.UIEvent.NavigateToBukaKasir INSTANCE = null;
            
            private NavigateToBukaKasir() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/beranda/BerandaViewModel$UIEvent$NavigateToTutupKasir;", "Lcom/bits/bee/bpmc/presentation/ui/beranda/BerandaViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToTutupKasir extends com.bits.bee.bpmc.presentation.ui.beranda.BerandaViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.beranda.BerandaViewModel.UIEvent.NavigateToTutupKasir INSTANCE = null;
            
            private NavigateToTutupKasir() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/beranda/BerandaViewModel$UIEvent$NavigateToDialogBukaKasir;", "Lcom/bits/bee/bpmc/presentation/ui/beranda/BerandaViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToDialogBukaKasir extends com.bits.bee.bpmc.presentation.ui.beranda.BerandaViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.beranda.BerandaViewModel.UIEvent.NavigateToDialogBukaKasir INSTANCE = null;
            
            private NavigateToDialogBukaKasir() {
                super();
            }
        }
    }
}