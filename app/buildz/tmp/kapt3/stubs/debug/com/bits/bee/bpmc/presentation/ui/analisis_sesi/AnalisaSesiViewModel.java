package com.bits.bee.bpmc.presentation.ui.analisis_sesi;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001-Bo\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u00a2\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020 J\u0006\u0010%\u001a\u00020 J\u0006\u0010&\u001a\u00020 J\u0014\u0010\'\u001a\u00020#2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)J\u001f\u0010+\u001a\u00020#2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/analisis_sesi/AnalisaSesiViewModel;", "Lcom/bits/bee/bpmc/presentation/base/BaseViewModel;", "Lcom/bits/bee/bpmc/presentation/ui/analisis_sesi/AnalisaSesiState;", "Lcom/bits/bee/bpmc/presentation/ui/analisis_sesi/AnalisaSesiViewModel$UIEvent;", "getUserByIdUseCase", "Lcom/bits/bee/bpmc/domain/usecase/rekap_sesi/GetUserByIdUseCase;", "getActivePossesUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActivePossesUseCase;", "getActivePossesListUseCase", "Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetActivePossesListUseCase;", "getSaleByPossesUseCase", "Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetSaleByPossesUseCase;", "getBpByDateUseCase", "Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetBpByDateUseCase;", "getSaledListUseCase", "Lcom/bits/bee/bpmc/domain/usecase/transaksi_penjualan/GetSaledListUseCase;", "getCountNotaUseCase", "Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetCountNotaUseCase;", "getCountNotaVoidUseCase", "Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetCountNotaVoidUseCase;", "getTotalPaidTunaiUseCase", "Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetTotalPaidTunaiUseCase;", "getTotalPaidDebitUseCase", "Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetTotalPaidDebitUseCase;", "getTotalPaidKreditUseCase", "Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetTotalPaidKreditUseCase;", "getTotalPaidGopayUseCase", "Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetTotalPaidGopayUseCase;", "getRankItemUseCase", "Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetRankItemUseCase;", "(Lcom/bits/bee/bpmc/domain/usecase/rekap_sesi/GetUserByIdUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/GetActivePossesUseCase;Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetActivePossesListUseCase;Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetSaleByPossesUseCase;Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetBpByDateUseCase;Lcom/bits/bee/bpmc/domain/usecase/transaksi_penjualan/GetSaledListUseCase;Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetCountNotaUseCase;Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetCountNotaVoidUseCase;Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetTotalPaidTunaiUseCase;Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetTotalPaidDebitUseCase;Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetTotalPaidKreditUseCase;Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetTotalPaidGopayUseCase;Lcom/bits/bee/bpmc/domain/usecase/analisa_sesi/GetRankItemUseCase;)V", "checkPosses", "Lkotlinx/coroutines/Job;", "getActivePosses", "getTotalNonTunai", "Ljava/math/BigDecimal;", "getValueDetail", "onClickBukaKasir", "onClickMenu", "totalAvg", "saleList", "", "Lcom/bits/bee/bpmc/domain/model/Sale;", "totalQty", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "UIEvent", "app_debug"})
public final class AnalisaSesiViewModel extends com.bits.bee.bpmc.presentation.base.BaseViewModel<com.bits.bee.bpmc.presentation.ui.analisis_sesi.AnalisaSesiState, com.bits.bee.bpmc.presentation.ui.analisis_sesi.AnalisaSesiViewModel.UIEvent> {
    private final com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetUserByIdUseCase getUserByIdUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase getActivePossesUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetActivePossesListUseCase getActivePossesListUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetSaleByPossesUseCase getSaleByPossesUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetBpByDateUseCase getBpByDateUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.GetSaledListUseCase getSaledListUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetCountNotaUseCase getCountNotaUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetCountNotaVoidUseCase getCountNotaVoidUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetTotalPaidTunaiUseCase getTotalPaidTunaiUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetTotalPaidDebitUseCase getTotalPaidDebitUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetTotalPaidKreditUseCase getTotalPaidKreditUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetTotalPaidGopayUseCase getTotalPaidGopayUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetRankItemUseCase getRankItemUseCase = null;
    
    @javax.inject.Inject()
    public AnalisaSesiViewModel(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.rekap_sesi.GetUserByIdUseCase getUserByIdUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase getActivePossesUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetActivePossesListUseCase getActivePossesListUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetSaleByPossesUseCase getSaleByPossesUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetBpByDateUseCase getBpByDateUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.transaksi_penjualan.GetSaledListUseCase getSaledListUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetCountNotaUseCase getCountNotaUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetCountNotaVoidUseCase getCountNotaVoidUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetTotalPaidTunaiUseCase getTotalPaidTunaiUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetTotalPaidDebitUseCase getTotalPaidDebitUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetTotalPaidKreditUseCase getTotalPaidKreditUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetTotalPaidGopayUseCase getTotalPaidGopayUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.analisa_sesi.GetRankItemUseCase getRankItemUseCase) {
        super();
    }
    
    private final kotlinx.coroutines.Job checkPosses() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getActivePosses() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getValueDetail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal getTotalNonTunai() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.math.BigDecimal totalAvg(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Sale> saleList) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object totalQty(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Sale> saleList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.math.BigDecimal> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickMenu() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job onClickBukaKasir() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/analisis_sesi/AnalisaSesiViewModel$UIEvent;", "", "()V", "RequestRiwayatSesi", "RequstDetailBukaKasir", "Lcom/bits/bee/bpmc/presentation/ui/analisis_sesi/AnalisaSesiViewModel$UIEvent$RequestRiwayatSesi;", "Lcom/bits/bee/bpmc/presentation/ui/analisis_sesi/AnalisaSesiViewModel$UIEvent$RequstDetailBukaKasir;", "app_debug"})
    public static abstract class UIEvent {
        
        private UIEvent() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/analisis_sesi/AnalisaSesiViewModel$UIEvent$RequestRiwayatSesi;", "Lcom/bits/bee/bpmc/presentation/ui/analisis_sesi/AnalisaSesiViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequestRiwayatSesi extends com.bits.bee.bpmc.presentation.ui.analisis_sesi.AnalisaSesiViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.analisis_sesi.AnalisaSesiViewModel.UIEvent.RequestRiwayatSesi INSTANCE = null;
            
            private RequestRiwayatSesi() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bits/bee/bpmc/presentation/ui/analisis_sesi/AnalisaSesiViewModel$UIEvent$RequstDetailBukaKasir;", "Lcom/bits/bee/bpmc/presentation/ui/analisis_sesi/AnalisaSesiViewModel$UIEvent;", "()V", "app_debug"})
        public static final class RequstDetailBukaKasir extends com.bits.bee.bpmc.presentation.ui.analisis_sesi.AnalisaSesiViewModel.UIEvent {
            @org.jetbrains.annotations.NotNull()
            public static final com.bits.bee.bpmc.presentation.ui.analisis_sesi.AnalisaSesiViewModel.UIEvent.RequstDetailBukaKasir INSTANCE = null;
            
            private RequstDetailBukaKasir() {
                super();
            }
        }
    }
}