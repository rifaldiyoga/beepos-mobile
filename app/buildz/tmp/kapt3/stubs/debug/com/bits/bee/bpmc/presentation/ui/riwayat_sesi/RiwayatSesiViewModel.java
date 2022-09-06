package com.bits.bee.bpmc.presentation.ui.riwayat_sesi;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001(B7\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0012J\u0006\u0010\u001b\u001a\u00020\u0012J\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J*\u0010\u001d\u001a\u00020\u00122\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0\u001f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001c\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0&2\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\'\u001a\u00020\u0012R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/riwayat_sesi/RiwayatSesiViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/riwayat_sesi/RiwayatSesiState;", "Lcom/bits/bee/bpmc/presentation/ui/riwayat_sesi/RiwayatSesiViewModel$UIEvent;", "getPossesHistoryUseCase", "Lcom/bits/bee/bpmc/domain/usecase/riwayat_sesi/GetPossesHistoryUseCase;", "getSortingUseCase", "Lcom/bits/bee/bpmc/domain/usecase/riwayat_sesi/GetSortingUseCase;", "getFilterSesiUseCase", "Lcom/bits/bee/bpmc/domain/usecase/riwayat_sesi/GetFilterSesiUseCase;", "getListPossesHistoryUseCase", "Lcom/bits/bee/bpmc/domain/usecase/riwayat_sesi/GetListPossesHistoryUseCase;", "getPossesByDateUseCase", "Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetPossesByDateUseCase;", "getFilterSortingUseCase", "Lcom/bits/bee/bpmc/domain/usecase/riwayat_sesi/GetFilterSortingUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/riwayat_sesi/GetPossesHistoryUseCase;Lcom/bits/bee/bpmc/domain/usecase/riwayat_sesi/GetSortingUseCase;Lcom/bits/bee/bpmc/domain/usecase/riwayat_sesi/GetFilterSesiUseCase;Lcom/bits/bee/bpmc/domain/usecase/riwayat_sesi/GetListPossesHistoryUseCase;Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetPossesByDateUseCase;Lcom/bits/bee/bpmc/domain/usecase/riwayat_sesi/GetFilterSortingUseCase;)V", "getFilterDays", "Lkotlinx/coroutines/Job;", "filter", "", "selectFilter", "", "getFilterSorting", "desc", "", "getHistory", "getListHistory", "getSorting", "parseMapPosses", "possesMap", "Ljava/util/SortedMap;", "", "", "Lcom/bits/bee/bpmc/domain/model/Posses;", "setListSesi", "", "list", "", "showDialog", "UIEvent", "app_debug"})
public final class RiwayatSesiViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.riwayat_sesi.RiwayatSesiState, com.bits.bee.bpmc.presentation.ui.riwayat_sesi.RiwayatSesiViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetPossesHistoryUseCase getPossesHistoryUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetSortingUseCase getSortingUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetFilterSesiUseCase getFilterSesiUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetListPossesHistoryUseCase getListPossesHistoryUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetPossesByDateUseCase getPossesByDateUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetFilterSortingUseCase getFilterSortingUseCase = null;
    
    @javax.inject.Inject()
    public RiwayatSesiViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetPossesHistoryUseCase getPossesHistoryUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetSortingUseCase getSortingUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetFilterSesiUseCase getFilterSesiUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetListPossesHistoryUseCase getListPossesHistoryUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetPossesByDateUseCase getPossesByDateUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.riwayat_sesi.GetFilterSortingUseCase getFilterSortingUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getListHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getFilterSorting(boolean desc, int filter, @org.jetbrains.annotations.NotNull()
    java.lang.String selectFilter) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getSorting(boolean desc) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getFilterDays(int filter, @org.jetbrains.annotations.NotNull()
    java.lang.String selectFilter) {
        return null;
    }
    
    public final void setListSesi(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Posses> list, boolean desc) {
    }
    
    private final kotlinx.coroutines.Job parseMapPosses(java.util.SortedMap<java.lang.Long, java.util.List<com.bits.bee.bpmc.domain.model.Posses>> possesMap, boolean desc) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job showDialog() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/riwayat_sesi/RiwayatSesiViewModel$UIEvent;", "", "()V", "RequestDialogFilter", "Lcom/bits/bee/bpmc/presentation/ui/riwayat_sesi/RiwayatSesiViewModel$UIEvent$RequestDialogFilter;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/riwayat_sesi/RiwayatSesiViewModel$UIEvent$RequestDialogFilter;", "Lcom/bits/bee/bpmc/presentation/ui/riwayat_sesi/RiwayatSesiViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestDialogFilter extends com.bits.bee.bpmc.presentation.ui.riwayat_sesi.RiwayatSesiViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.riwayat_sesi.RiwayatSesiViewModel.UIEvent.RequestDialogFilter INSTANCE = null;
            
            private RequestDialogFilter() {
                super();
            }
        }
    }
}