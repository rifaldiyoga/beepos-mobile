package com.bits.bee.bpmc.presentation.ui.pembayaran;

import java.lang.System;

/**
 * Created by aldi on 25/05/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranState;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel$UIEvent;", "addTransactionUseCase", "Lcom/bits/bee/bpmc/domain/usecase/pos/AddTransactionUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/pos/AddTransactionUseCase;)V", "onNonTunaiClick", "Lkotlinx/coroutines/Job;", "onRekomBayarClick", "data", "", "onTunaiClick", "sale", "Lcom/bits/bee/bpmc/domain/model/Sale;", "saledList", "", "Lcom/bits/bee/bpmc/domain/model/Saled;", "UIEvent", "app_debug"})
public final class PembayaranViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.pembayaran.PembayaranState, com.bits.bee.bpmc.presentation.ui.pembayaran.PembayaranViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.pos.AddTransactionUseCase addTransactionUseCase = null;
    
    @javax.inject.Inject()
    public PembayaranViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pos.AddTransactionUseCase addTransactionUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onTunaiClick(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Saled> saledList) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onNonTunaiClick() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onRekomBayarClick(@org.jetbrains.annotations.NotNull()
    java.lang.String data) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel$UIEvent;", "", "()V", "NavigateNonTunai", "NavigateTransaksiBerhasil", "RequestBayar", "RequestRekomBayar", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel$UIEvent$NavigateNonTunai;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel$UIEvent$NavigateTransaksiBerhasil;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel$UIEvent$RequestBayar;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel$UIEvent$RequestRekomBayar;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel$UIEvent$NavigateTransaksiBerhasil;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateTransaksiBerhasil extends com.bits.bee.bpmc.presentation.ui.pembayaran.PembayaranViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pembayaran.PembayaranViewModel.UIEvent.NavigateTransaksiBerhasil INSTANCE = null;
            
            private NavigateTransaksiBerhasil() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel$UIEvent$NavigateNonTunai;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateNonTunai extends com.bits.bee.bpmc.presentation.ui.pembayaran.PembayaranViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pembayaran.PembayaranViewModel.UIEvent.NavigateNonTunai INSTANCE = null;
            
            private NavigateNonTunai() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel$UIEvent$RequestRekomBayar;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestRekomBayar extends com.bits.bee.bpmc.presentation.ui.pembayaran.PembayaranViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pembayaran.PembayaranViewModel.UIEvent.RequestRekomBayar INSTANCE = null;
            
            private RequestRekomBayar() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel$UIEvent$RequestBayar;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran/PembayaranViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestBayar extends com.bits.bee.bpmc.presentation.ui.pembayaran.PembayaranViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pembayaran.PembayaranViewModel.UIEvent.RequestBayar INSTANCE = null;
            
            private RequestBayar() {
                super();
            }
        }
    }
}