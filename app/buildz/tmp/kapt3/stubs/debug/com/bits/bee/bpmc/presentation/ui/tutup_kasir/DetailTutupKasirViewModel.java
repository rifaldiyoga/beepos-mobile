package com.bits.bee.bpmc.presentation.ui.tutup_kasir;

import java.lang.System;

/**
 * Created by aldi on 08/06/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\t"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/tutup_kasir/DetailTutupKasirViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/tutup_kasir/DetailTutupKasirState;", "Lcom/bits/bee/bpmc/presentation/ui/tutup_kasir/DetailTutupKasirViewModel$UIEvent;", "()V", "onCLickMenu", "Lkotlinx/coroutines/Job;", "onTutupKasir", "UIEvent", "app_debug"})
public final class DetailTutupKasirViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.tutup_kasir.DetailTutupKasirState, com.bits.bee.bpmc.presentation.ui.tutup_kasir.DetailTutupKasirViewModel.UIEvent> {
    
    public DetailTutupKasirViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onTutupKasir() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onCLickMenu() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/tutup_kasir/DetailTutupKasirViewModel$UIEvent;", "", "()V", "RequestRekapSesi", "RequestSave", "Lcom/bits/bee/bpmc/presentation/ui/tutup_kasir/DetailTutupKasirViewModel$UIEvent$RequestRekapSesi;", "Lcom/bits/bee/bpmc/presentation/ui/tutup_kasir/DetailTutupKasirViewModel$UIEvent$RequestSave;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/tutup_kasir/DetailTutupKasirViewModel$UIEvent$RequestSave;", "Lcom/bits/bee/bpmc/presentation/ui/tutup_kasir/DetailTutupKasirViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestSave extends com.bits.bee.bpmc.presentation.ui.tutup_kasir.DetailTutupKasirViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.tutup_kasir.DetailTutupKasirViewModel.UIEvent.RequestSave INSTANCE = null;
            
            private RequestSave() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/tutup_kasir/DetailTutupKasirViewModel$UIEvent$RequestRekapSesi;", "Lcom/bits/bee/bpmc/presentation/ui/tutup_kasir/DetailTutupKasirViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestRekapSesi extends com.bits.bee.bpmc.presentation.ui.tutup_kasir.DetailTutupKasirViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.tutup_kasir.DetailTutupKasirViewModel.UIEvent.RequestRekapSesi INSTANCE = null;
            
            private RequestRekapSesi() {
                super();
            }
        }
    }
}