package com.bits.bee.bpmc.presentation.ui.pilih_cabang;

import java.lang.System;

/**
 * Created by aldi on 17/03/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rR#\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pilih_cabang/PilihCabangViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/pilih_cabang/PilihCabangState;", "Lcom/bits/bee/bpmc/presentation/ui/pilih_cabang/PilihCabangViewModel$UIEvent;", "getLatestBranchUseCase", "Lcom/bits/bee/bpmc/domain/usecase/pilih_cabang/GetLatestBranchUseCase;", "updateActiveBranchUseCase", "Lcom/bits/bee/bpmc/domain/usecase/pilih_cabang/UpdateActiveBranchUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/pilih_cabang/GetLatestBranchUseCase;Lcom/bits/bee/bpmc/domain/usecase/pilih_cabang/UpdateActiveBranchUseCase;)V", "getLatestBranch", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "", "Lcom/bits/bee/bpmc/domain/model/Branch;", "getGetLatestBranch", "()Lkotlinx/coroutines/flow/Flow;", "onItemClick", "Lkotlinx/coroutines/Job;", "branch", "UIEvent", "app_debug"})
public final class PilihCabangViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.pilih_cabang.PilihCabangState, com.bits.bee.bpmc.presentation.ui.pilih_cabang.PilihCabangViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.pilih_cabang.GetLatestBranchUseCase getLatestBranchUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.pilih_cabang.UpdateActiveBranchUseCase updateActiveBranchUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Branch>>> getLatestBranch = null;
    
    @javax.inject.Inject()
    public PilihCabangViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pilih_cabang.GetLatestBranchUseCase getLatestBranchUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pilih_cabang.UpdateActiveBranchUseCase updateActiveBranchUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Branch>>> getGetLatestBranch() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onItemClick(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Branch branch) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pilih_cabang/PilihCabangViewModel$UIEvent;", "", "()V", "NavigateToCashier", "Lcom/bits/bee/bpmc/presentation/ui/pilih_cabang/PilihCabangViewModel$UIEvent$NavigateToCashier;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pilih_cabang/PilihCabangViewModel$UIEvent$NavigateToCashier;", "Lcom/bits/bee/bpmc/presentation/ui/pilih_cabang/PilihCabangViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToCashier extends com.bits.bee.bpmc.presentation.ui.pilih_cabang.PilihCabangViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pilih_cabang.PilihCabangViewModel.UIEvent.NavigateToCashier INSTANCE = null;
            
            private NavigateToCashier() {
                super();
            }
        }
    }
}