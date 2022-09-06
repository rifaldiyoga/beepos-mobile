package com.bits.bee.bpmc.presentation.ui.detail_riwayat_sesi;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u001f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\fH\u0002J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/detail_riwayat_sesi/DetailRiwayatSesiViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/detail_riwayat_sesi/DetailRiwayatSesiState;", "Lcom/bits/bee/bpmc/presentation/ui/detail_riwayat_sesi/DetailRiwayatSesiViewModel$UIEvent;", "getActiveBranchUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveBranchUseCase;", "getUserByIdUseCase", "Lcom/bits/bee/bpmc/domain/usecase/rekap_sesi/GetUserByIdUseCase;", "getCashierByIdUseCase", "Lcom/bits/bee/bpmc/domain/usecase/riwayat_sesi/GetCashierByIdUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveBranchUseCase;Lcom/bits/bee/bpmc/domain/usecase/rekap_sesi/GetUserByIdUseCase;Lcom/bits/bee/bpmc/domain/usecase/riwayat_sesi/GetCashierByIdUseCase;)V", "detailAnalisaSesi", "Lkotlinx/coroutines/Job;", "detailValue", "getActiveBranch", "onClickDetail", "model", "Lcom/bits/bee/bpmc/domain/model/Posses;", "UIEvent", "app_debug"})
public final class DetailRiwayatSesiViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.detail_riwayat_sesi.DetailRiwayatSesiState, com.bits.bee.bpmc.presentation.ui.detail_riwayat_sesi.DetailRiwayatSesiViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase getActiveBranchUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetUserByIdUseCase getUserByIdUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetCashierByIdUseCase getCashierByIdUseCase = null;
    
    @javax.inject.Inject()
    public DetailRiwayatSesiViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase getActiveBranchUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetUserByIdUseCase getUserByIdUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetCashierByIdUseCase getCashierByIdUseCase) {
        super();
    }
    
    private final kotlinx.coroutines.Job getActiveBranch() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job detailValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickDetail(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Posses model) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job detailAnalisaSesi() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/detail_riwayat_sesi/DetailRiwayatSesiViewModel$UIEvent;", "", "()V", "RequestAnalisaSesi", "RequestDetailPendapatan", "Lcom/bits/bee/bpmc/presentation/ui/detail_riwayat_sesi/DetailRiwayatSesiViewModel$UIEvent$RequestAnalisaSesi;", "Lcom/bits/bee/bpmc/presentation/ui/detail_riwayat_sesi/DetailRiwayatSesiViewModel$UIEvent$RequestDetailPendapatan;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/detail_riwayat_sesi/DetailRiwayatSesiViewModel$UIEvent$RequestDetailPendapatan;", "Lcom/bits/bee/bpmc/presentation/ui/detail_riwayat_sesi/DetailRiwayatSesiViewModel$UIEvent;", "model", "Lcom/bits/bee/bpmc/domain/model/Posses;", "(Lcom/bits/bee/bpmc/domain/model/Posses;)V", "getModel", "()Lcom/bits/bee/bpmc/domain/model/Posses;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class RequestDetailPendapatan extends com.bits.bee.bpmc.presentation.ui.detail_riwayat_sesi.DetailRiwayatSesiViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            private final com.bits.bee.bpmc.domain.model.Posses model = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.presentation.ui.detail_riwayat_sesi.DetailRiwayatSesiViewModel.UIEvent.RequestDetailPendapatan copy(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Posses model) {
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
            
            public RequestDetailPendapatan(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Posses model) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Posses component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Posses getModel() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/detail_riwayat_sesi/DetailRiwayatSesiViewModel$UIEvent$RequestAnalisaSesi;", "Lcom/bits/bee/bpmc/presentation/ui/detail_riwayat_sesi/DetailRiwayatSesiViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestAnalisaSesi extends com.bits.bee.bpmc.presentation.ui.detail_riwayat_sesi.DetailRiwayatSesiViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.detail_riwayat_sesi.DetailRiwayatSesiViewModel.UIEvent.RequestAnalisaSesi INSTANCE = null;
            
            private RequestAnalisaSesi() {
                super();
            }
        }
    }
}