package com.bits.bee.bpmc.presentation.dialog.draft_list;

import java.lang.System;

/**
 * Created by aldi on 24/06/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/draft_list/DraftListViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/dialog/draft_list/DraftListDialogState;", "Lcom/bits/bee/bpmc/presentation/dialog/draft_list/DraftListViewModel$UIEvent;", "getLatestDraftUseCase", "Lcom/bits/bee/bpmc/domain/usecase/draft/GetLatestDraftUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/draft/GetLatestDraftUseCase;)V", "getDraftList", "Lkotlinx/coroutines/Job;", "onItemClick", "sale", "Lcom/bits/bee/bpmc/domain/model/Sale;", "UIEvent", "app_debug"})
public final class DraftListViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.dialog.draft_list.DraftListDialogState, com.bits.bee.bpmc.presentation.dialog.draft_list.DraftListViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.draft.GetLatestDraftUseCase getLatestDraftUseCase = null;
    
    @javax.inject.Inject()
    public DraftListViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.draft.GetLatestDraftUseCase getLatestDraftUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onItemClick(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getDraftList() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/draft_list/DraftListViewModel$UIEvent;", "", "()V", "RequestDraft", "Lcom/bits/bee/bpmc/presentation/dialog/draft_list/DraftListViewModel$UIEvent$RequestDraft;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/draft_list/DraftListViewModel$UIEvent$RequestDraft;", "Lcom/bits/bee/bpmc/presentation/dialog/draft_list/DraftListViewModel$UIEvent;", "sale", "Lcom/bits/bee/bpmc/domain/model/Sale;", "(Lcom/bits/bee/bpmc/domain/model/Sale;)V", "getSale", "()Lcom/bits/bee/bpmc/domain/model/Sale;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class RequestDraft extends com.bits.bee.bpmc.presentation.dialog.draft_list.DraftListViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            private final com.bits.bee.bpmc.domain.model.Sale sale = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.presentation.dialog.draft_list.DraftListViewModel.UIEvent.RequestDraft copy(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Sale sale) {
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
            
            public RequestDraft(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Sale sale) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Sale component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Sale getSale() {
                return null;
            }
        }
    }
}