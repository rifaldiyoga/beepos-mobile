package com.bits.bee.bpmc.presentation.ui.lainnya;

import java.lang.System;

/**
 * Created by aldi on 07/06/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaState;", "Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent;", "()V", "onCekStok", "Lkotlinx/coroutines/Job;", "onDownload", "onKelolaProduk", "onPengaturan", "onRekapKas", "onRekapProduk", "onUploadManual", "UIEvent", "app_debug"})
public final class LainnyaViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.lainnya.LainnyaState, com.bits.bee.bpmc.presentation.ui.lainnya.LainnyaViewModel.UIEvent> {
    
    public LainnyaViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onUploadManual() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onCekStok() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onRekapKas() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onKelolaProduk() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onPengaturan() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onRekapProduk() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onDownload() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent;", "", "()V", "NavigateToCekStok", "NavigateToDownload", "NavigateToKelolaProduk", "NavigateToPengaturan", "NavigateToRekapKas", "NavigateToRekapProduk", "NavigateToUploadManual", "Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent$NavigateToCekStok;", "Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent$NavigateToDownload;", "Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent$NavigateToKelolaProduk;", "Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent$NavigateToPengaturan;", "Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent$NavigateToRekapKas;", "Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent$NavigateToRekapProduk;", "Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent$NavigateToUploadManual;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent$NavigateToUploadManual;", "Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToUploadManual extends com.bits.bee.bpmc.presentation.ui.lainnya.LainnyaViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.lainnya.LainnyaViewModel.UIEvent.NavigateToUploadManual INSTANCE = null;
            
            private NavigateToUploadManual() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent$NavigateToCekStok;", "Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToCekStok extends com.bits.bee.bpmc.presentation.ui.lainnya.LainnyaViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.lainnya.LainnyaViewModel.UIEvent.NavigateToCekStok INSTANCE = null;
            
            private NavigateToCekStok() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent$NavigateToRekapKas;", "Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToRekapKas extends com.bits.bee.bpmc.presentation.ui.lainnya.LainnyaViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.lainnya.LainnyaViewModel.UIEvent.NavigateToRekapKas INSTANCE = null;
            
            private NavigateToRekapKas() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent$NavigateToRekapProduk;", "Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToRekapProduk extends com.bits.bee.bpmc.presentation.ui.lainnya.LainnyaViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.lainnya.LainnyaViewModel.UIEvent.NavigateToRekapProduk INSTANCE = null;
            
            private NavigateToRekapProduk() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent$NavigateToKelolaProduk;", "Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToKelolaProduk extends com.bits.bee.bpmc.presentation.ui.lainnya.LainnyaViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.lainnya.LainnyaViewModel.UIEvent.NavigateToKelolaProduk INSTANCE = null;
            
            private NavigateToKelolaProduk() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent$NavigateToPengaturan;", "Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToPengaturan extends com.bits.bee.bpmc.presentation.ui.lainnya.LainnyaViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.lainnya.LainnyaViewModel.UIEvent.NavigateToPengaturan INSTANCE = null;
            
            private NavigateToPengaturan() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent$NavigateToDownload;", "Lcom/bits/bee/bpmc/presentation/ui/lainnya/LainnyaViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToDownload extends com.bits.bee.bpmc.presentation.ui.lainnya.LainnyaViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.lainnya.LainnyaViewModel.UIEvent.NavigateToDownload INSTANCE = null;
            
            private NavigateToDownload() {
                super();
            }
        }
    }
}