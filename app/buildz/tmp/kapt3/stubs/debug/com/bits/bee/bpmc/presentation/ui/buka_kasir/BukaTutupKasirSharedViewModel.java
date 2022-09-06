package com.bits.bee.bpmc.presentation.ui.buka_kasir;

import java.lang.System;

/**
 * Created by aldi on 20/06/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB?\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0014J\u0006\u0010\u001a\u001a\u00020\u0014J\u0006\u0010\u001b\u001a\u00020\u0014J\u0006\u0010\u001c\u001a\u00020\u0014J\u0006\u0010\u001d\u001a\u00020\u0014J\u0006\u0010\u001e\u001a\u00020\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/BukaTutupKasirSharedViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/BukaTutupKasirState;", "Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/BukaTutupKasirSharedViewModel$UIEvent;", "getActivePossesUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActivePossesUseCase;", "getActiveCashierUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveCashierUseCase;", "getActiveBranchUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveBranchUseCase;", "bukaKasirUseCase", "Lcom/bits/bee/bpmc/domain/usecase/buka_kasir/BukaKasirUseCase;", "tutupKasirUseCase", "Lcom/bits/bee/bpmc/domain/usecase/tutup_kasir/TutupKasirUseCase;", "getCounterShiftUseCase", "Lcom/bits/bee/bpmc/domain/usecase/buka_kasir/GetCounterShiftUseCase;", "getUserByIdUseCase", "Lcom/bits/bee/bpmc/domain/usecase/rekap_sesi/GetUserByIdUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/common/GetActivePossesUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveCashierUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveBranchUseCase;Lcom/bits/bee/bpmc/domain/usecase/buka_kasir/BukaKasirUseCase;Lcom/bits/bee/bpmc/domain/usecase/tutup_kasir/TutupKasirUseCase;Lcom/bits/bee/bpmc/domain/usecase/buka_kasir/GetCounterShiftUseCase;Lcom/bits/bee/bpmc/domain/usecase/rekap_sesi/GetUserByIdUseCase;)V", "doBukaKasir", "Lkotlinx/coroutines/Job;", "modal", "Ljava/math/BigDecimal;", "sesi", "", "doTutupKasir", "getActiveBranch", "getActiveCashier", "getActivePosses", "getUser", "setShift", "UIEvent", "app_debug"})
public final class BukaTutupKasirSharedViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.buka_kasir.BukaTutupKasirState, com.bits.bee.bpmc.presentation.ui.buka_kasir.BukaTutupKasirSharedViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase getActivePossesUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase getActiveCashierUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase getActiveBranchUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.buka_kasir.BukaKasirUseCase bukaKasirUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.tutup_kasir.TutupKasirUseCase tutupKasirUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.buka_kasir.GetCounterShiftUseCase getCounterShiftUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetUserByIdUseCase getUserByIdUseCase = null;
    
    @javax.inject.Inject()
    public BukaTutupKasirSharedViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase getActivePossesUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase getActiveCashierUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase getActiveBranchUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.buka_kasir.BukaKasirUseCase bukaKasirUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.tutup_kasir.TutupKasirUseCase tutupKasirUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.buka_kasir.GetCounterShiftUseCase getCounterShiftUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetUserByIdUseCase getUserByIdUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getActivePosses() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getActiveBranch() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getActiveCashier() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job setShift() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job doBukaKasir(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal modal, int sesi) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job doTutupKasir() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/buka_kasir/BukaTutupKasirSharedViewModel$UIEvent;", "", "()V", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
    }
}