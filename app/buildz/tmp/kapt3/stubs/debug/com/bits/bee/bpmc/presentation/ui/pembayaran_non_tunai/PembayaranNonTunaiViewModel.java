package com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai;

import java.lang.System;

/**
 * Created by aldi on 02/06/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pembayaran_non_tunai/PembayaranNonTunaiViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran_non_tunai/PembayaranNonTunaiState;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran_non_tunai/PembayaranNonTunaiViewModel$UIEvent;", "getActivePmtd", "Lcom/bits/bee/bpmc/domain/usecase/pembayaran/GetActivePmtd;", "(Lcom/bits/bee/bpmc/domain/usecase/pembayaran/GetActivePmtd;)V", "loadPmtd", "Lkotlinx/coroutines/Job;", "onClickItem", "pmtd", "Lcom/bits/bee/bpmc/domain/model/Pmtd;", "UIEvent", "app_debug"})
public final class PembayaranNonTunaiViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai.PembayaranNonTunaiState, com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai.PembayaranNonTunaiViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.pembayaran.GetActivePmtd getActivePmtd = null;
    
    @javax.inject.Inject()
    public PembayaranNonTunaiViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pembayaran.GetActivePmtd getActivePmtd) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadPmtd() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickItem(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Pmtd pmtd) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pembayaran_non_tunai/PembayaranNonTunaiViewModel$UIEvent;", "", "()V", "NavigateToDebitKredit", "NavigateToGopay", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran_non_tunai/PembayaranNonTunaiViewModel$UIEvent$NavigateToDebitKredit;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran_non_tunai/PembayaranNonTunaiViewModel$UIEvent$NavigateToGopay;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pembayaran_non_tunai/PembayaranNonTunaiViewModel$UIEvent$NavigateToGopay;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran_non_tunai/PembayaranNonTunaiViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToGopay extends com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai.PembayaranNonTunaiViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai.PembayaranNonTunaiViewModel.UIEvent.NavigateToGopay INSTANCE = null;
            
            private NavigateToGopay() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pembayaran_non_tunai/PembayaranNonTunaiViewModel$UIEvent$NavigateToDebitKredit;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran_non_tunai/PembayaranNonTunaiViewModel$UIEvent;", "pmtd", "Lcom/bits/bee/bpmc/domain/model/Pmtd;", "(Lcom/bits/bee/bpmc/domain/model/Pmtd;)V", "getPmtd", "()Lcom/bits/bee/bpmc/domain/model/Pmtd;", "setPmtd", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class NavigateToDebitKredit extends com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai.PembayaranNonTunaiViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            private com.bits.bee.bpmc.domain.model.Pmtd pmtd;
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai.PembayaranNonTunaiViewModel.UIEvent.NavigateToDebitKredit copy(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Pmtd pmtd) {
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
            
            public NavigateToDebitKredit(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Pmtd pmtd) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Pmtd component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.bits.bee.bpmc.domain.model.Pmtd getPmtd() {
                return null;
            }
            
            public final void setPmtd(@org.jetbrains.annotations.NotNull()
            com.bits.bee.bpmc.domain.model.Pmtd p0) {
            }
        }
    }
}