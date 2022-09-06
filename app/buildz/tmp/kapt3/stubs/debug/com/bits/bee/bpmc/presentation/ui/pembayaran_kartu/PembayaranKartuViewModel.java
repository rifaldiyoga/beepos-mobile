package com.bits.bee.bpmc.presentation.ui.pembayaran_kartu;

import java.lang.System;

/**
 * Created by aldi on 02/06/22.
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u001f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pembayaran_kartu/PembayaranKartuViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran_kartu/PembayaranKartuState;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran_kartu/PembayaranKartuViewModel$UIEvent;", "getActiveEdc", "Lcom/bits/bee/bpmc/domain/usecase/pembayaran/GetActiveEdc;", "getActiveEdcSurc", "Lcom/bits/bee/bpmc/domain/usecase/pembayaran/GetActiveEdcSurc;", "addTransactionUseCase", "Lcom/bits/bee/bpmc/domain/usecase/pos/AddTransactionUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/pembayaran/GetActiveEdc;Lcom/bits/bee/bpmc/domain/usecase/pembayaran/GetActiveEdcSurc;Lcom/bits/bee/bpmc/domain/usecase/pos/AddTransactionUseCase;)V", "onBayarClick", "Lkotlinx/coroutines/Job;", "sale", "Lcom/bits/bee/bpmc/domain/model/Sale;", "saledList", "", "Lcom/bits/bee/bpmc/domain/model/Saled;", "UIEvent", "app_debug"})
public final class PembayaranKartuViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.pembayaran_kartu.PembayaranKartuState, com.bits.bee.bpmc.presentation.ui.pembayaran_kartu.PembayaranKartuViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.pembayaran.GetActiveEdc getActiveEdc = null;
    private final com.bits.bee.bpmc.domain.usecase.pembayaran.GetActiveEdcSurc getActiveEdcSurc = null;
    private final com.bits.bee.bpmc.domain.usecase.pos.AddTransactionUseCase addTransactionUseCase = null;
    
    @javax.inject.Inject()
    public PembayaranKartuViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pembayaran.GetActiveEdc getActiveEdc, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pembayaran.GetActiveEdcSurc getActiveEdcSurc, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pos.AddTransactionUseCase addTransactionUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onBayarClick(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Saled> saledList) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pembayaran_kartu/PembayaranKartuViewModel$UIEvent;", "", "()V", "NavigateToTransaksiBerhasil", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran_kartu/PembayaranKartuViewModel$UIEvent$NavigateToTransaksiBerhasil;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/pembayaran_kartu/PembayaranKartuViewModel$UIEvent$NavigateToTransaksiBerhasil;", "Lcom/bits/bee/bpmc/presentation/ui/pembayaran_kartu/PembayaranKartuViewModel$UIEvent;", "()V", "app_debug"})
        public static final class NavigateToTransaksiBerhasil extends com.bits.bee.bpmc.presentation.ui.pembayaran_kartu.PembayaranKartuViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.pembayaran_kartu.PembayaranKartuViewModel.UIEvent.NavigateToTransaksiBerhasil INSTANCE = null;
            
            private NavigateToTransaksiBerhasil() {
                super();
            }
        }
    }
}