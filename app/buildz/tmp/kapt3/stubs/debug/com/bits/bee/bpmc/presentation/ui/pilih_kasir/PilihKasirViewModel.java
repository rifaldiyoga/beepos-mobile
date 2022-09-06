package com.bits.bee.bpmc.presentation.ui.pilih_kasir;

import java.lang.System;

/**
 * Created by aldi on 22/03/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\rR \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pilih_kasir/PilihKasirViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/pilih_kasir/PilihKasirState;", "Lcom/bits/bee/bpmc/presentation/ui/pilih_kasir/PilihKasirViewModel$UIEvent;", "getLatestCashierUseCase", "Lcom/bits/bee/bpmc/domain/usecase/pilih_kasir/GetLatestCashierUseCase;", "updateActiveCashierUseCase", "Lcom/bits/bee/bpmc/domain/usecase/pilih_kasir/UpdateActiveCashierUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/pilih_kasir/GetLatestCashierUseCase;Lcom/bits/bee/bpmc/domain/usecase/pilih_kasir/UpdateActiveCashierUseCase;)V", "cashierEntityResponse", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/bits/bee/bpmc/utils/Resource;", "", "Lcom/bits/bee/bpmc/domain/model/Cashier;", "getCashierList", "Lkotlinx/coroutines/Job;", "observeCashierResponse", "Landroidx/lifecycle/LiveData;", "onItemClick", "cashier", "UIEvent", "app_debug"})
public final class PilihKasirViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.pilih_kasir.PilihKasirState, com.bits.bee.bpmc.presentation.ui.pilih_kasir.PilihKasirViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.pilih_kasir.GetLatestCashierUseCase getLatestCashierUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.pilih_kasir.UpdateActiveCashierUseCase updateActiveCashierUseCase = null;
    private androidx.lifecycle.MediatorLiveData<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Cashier>>> cashierEntityResponse;
    
    @javax.inject.Inject()
    public PilihKasirViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pilih_kasir.GetLatestCashierUseCase getLatestCashierUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pilih_kasir.UpdateActiveCashierUseCase updateActiveCashierUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Cashier>>> observeCashierResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getCashierList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onItemClick(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Cashier cashier) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pilih_kasir/PilihKasirViewModel$UIEvent;", "", "()V", "NavigateToPin", "Lcom/bits/bee/bpmc/presentation/ui/pilih_kasir/PilihKasirViewModel$UIEvent$NavigateToPin;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pilih_kasir/PilihKasirViewModel$UIEvent$NavigateToPin;", "Lcom/bits/bee/bpmc/presentation/ui/pilih_kasir/PilihKasirViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToPin extends com.bits.bee.bpmc.presentation.ui.pilih_kasir.PilihKasirViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pilih_kasir.PilihKasirViewModel.UIEvent.NavigateToPin INSTANCE = null;
            
            private NavigateToPin() {
                super();
            }
        }
    }
}