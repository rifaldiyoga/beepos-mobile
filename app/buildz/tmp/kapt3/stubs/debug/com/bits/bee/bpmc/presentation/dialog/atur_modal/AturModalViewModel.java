package com.bits.bee.bpmc.presentation.dialog.atur_modal;

import java.lang.System;

/**
 * Created by aldi on 09/06/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/atur_modal/AturModalViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/dialog/atur_modal/AturModalState;", "Lcom/bits/bee/bpmc/presentation/dialog/atur_modal/AturModalViewModel$UIEvent;", "()V", "onBukaKasirClick", "Lkotlinx/coroutines/Job;", "onDoneSave", "saveBukaKasir", "UIEvent", "app_debug"})
public final class AturModalViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.dialog.atur_modal.AturModalState, com.bits.bee.bpmc.presentation.dialog.atur_modal.AturModalViewModel.UIEvent> {
    
    @javax.inject.Inject()
    public AturModalViewModel() {
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
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/atur_modal/AturModalViewModel$UIEvent;", "", "()V", "NavigateToDefaultModal", "NavigateToPos", "RequestSave", "Lcom/bits/bee/bpmc/presentation/dialog/atur_modal/AturModalViewModel$UIEvent$NavigateToDefaultModal;", "Lcom/bits/bee/bpmc/presentation/dialog/atur_modal/AturModalViewModel$UIEvent$NavigateToPos;", "Lcom/bits/bee/bpmc/presentation/dialog/atur_modal/AturModalViewModel$UIEvent$RequestSave;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/atur_modal/AturModalViewModel$UIEvent$NavigateToPos;", "Lcom/bits/bee/bpmc/presentation/dialog/atur_modal/AturModalViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToPos extends com.bits.bee.bpmc.presentation.dialog.atur_modal.AturModalViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.dialog.atur_modal.AturModalViewModel.UIEvent.NavigateToPos INSTANCE = null;
            
            private NavigateToPos() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/atur_modal/AturModalViewModel$UIEvent$NavigateToDefaultModal;", "Lcom/bits/bee/bpmc/presentation/dialog/atur_modal/AturModalViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToDefaultModal extends com.bits.bee.bpmc.presentation.dialog.atur_modal.AturModalViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.dialog.atur_modal.AturModalViewModel.UIEvent.NavigateToDefaultModal INSTANCE = null;
            
            private NavigateToDefaultModal() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/dialog/atur_modal/AturModalViewModel$UIEvent$RequestSave;", "Lcom/bits/bee/bpmc/presentation/dialog/atur_modal/AturModalViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestSave extends com.bits.bee.bpmc.presentation.dialog.atur_modal.AturModalViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.dialog.atur_modal.AturModalViewModel.UIEvent.RequestSave INSTANCE = null;
            
            private RequestSave() {
                super();
            }
        }
    }
}