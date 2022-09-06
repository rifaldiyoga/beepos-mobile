package com.bits.bee.bpmc.presentation.ui.detail_transaksi_penjualan;

import java.lang.System;

/**
 * Created by aldi on 23/06/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/detail_transaksi_penjualan/DetailTransaksiPenjualanViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/detail_transaksi_penjualan/DetailTransaksiPenjualanState;", "Lcom/bits/bee/bpmc/presentation/ui/detail_transaksi_penjualan/DetailTransaksiPenjualanViewModel$UIEvent;", "getSaledListUseCase", "Lcom/bits/bee/bpmc/domain/usecase/transaksi_penjualan/GetSaledListUseCase;", "voidTransactionUseCase", "Lcom/bits/bee/bpmc/domain/usecase/transaksi_penjualan/VoidTransactionUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/transaksi_penjualan/GetSaledListUseCase;Lcom/bits/bee/bpmc/domain/usecase/transaksi_penjualan/VoidTransactionUseCase;)V", "getSaledList", "Lkotlinx/coroutines/Job;", "onClickVoid", "UIEvent", "app_debug"})
public final class DetailTransaksiPenjualanViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.detail_transaksi_penjualan.DetailTransaksiPenjualanState, com.bits.bee.bpmc.presentation.ui.detail_transaksi_penjualan.DetailTransaksiPenjualanViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.GetSaledListUseCase getSaledListUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.VoidTransactionUseCase voidTransactionUseCase = null;
    
    @javax.inject.Inject()
    public DetailTransaksiPenjualanViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.GetSaledListUseCase getSaledListUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.VoidTransactionUseCase voidTransactionUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickVoid() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getSaledList() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/detail_transaksi_penjualan/DetailTransaksiPenjualanViewModel$UIEvent;", "", "()V", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
    }
}