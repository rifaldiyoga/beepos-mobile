package com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/rekap_sesi_kasir/RekapSesiViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/rekap_sesi_kasir/RekapSesiState;", "Lcom/bits/bee/bpmc/presentation/ui/rekap_sesi_kasir/RekapSesiViewModel$UIEvent;", "getListPossesUseCase", "Lcom/bits/bee/bpmc/domain/usecase/rekap_sesi/GetListPossesUseCase;", "getDefaultUserUseCase", "Lcom/bits/bee/bpmc/domain/usecase/rekap_sesi/GetDefaultUserUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/rekap_sesi/GetListPossesUseCase;Lcom/bits/bee/bpmc/domain/usecase/rekap_sesi/GetDefaultUserUseCase;)V", "mPosses", "Lcom/bits/bee/bpmc/domain/model/Posses;", "possesList", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "getPossesList", "()Lkotlinx/coroutines/flow/Flow;", "setPossesList", "(Lkotlinx/coroutines/flow/Flow;)V", "getRekapsesi", "Lkotlinx/coroutines/Job;", "getUser", "UIEvent", "app_debug"})
public final class RekapSesiViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir.RekapSesiState, com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir.RekapSesiViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetListPossesUseCase getListPossesUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetDefaultUserUseCase getDefaultUserUseCase = null;
    private com.bits.bee.bpmc.domain.model.Posses mPosses;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Posses>> possesList;
    
    @javax.inject.Inject()
    public RekapSesiViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetListPossesUseCase getListPossesUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetDefaultUserUseCase getDefaultUserUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Posses>> getPossesList() {
        return null;
    }
    
    public final void setPossesList(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Posses>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getRekapsesi() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/rekap_sesi_kasir/RekapSesiViewModel$UIEvent;", "", "()V", "RequestInfoTax", "Lcom/bits/bee/bpmc/presentation/ui/rekap_sesi_kasir/RekapSesiViewModel$UIEvent$RequestInfoTax;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/rekap_sesi_kasir/RekapSesiViewModel$UIEvent$RequestInfoTax;", "Lcom/bits/bee/bpmc/presentation/ui/rekap_sesi_kasir/RekapSesiViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestInfoTax extends com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir.RekapSesiViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.rekap_sesi_kasir.RekapSesiViewModel.UIEvent.RequestInfoTax INSTANCE = null;
            
            private RequestInfoTax() {
                super();
            }
        }
    }
}