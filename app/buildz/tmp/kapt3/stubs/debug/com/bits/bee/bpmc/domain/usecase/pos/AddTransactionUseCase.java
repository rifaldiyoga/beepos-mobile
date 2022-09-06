package com.bits.bee.bpmc.domain.usecase.pos;

import java.lang.System;

/**
 * Created by aldi on 20/05/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B_\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\u0002\u0010\u0018J[\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\b\b\u0002\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010\'\u001a\u00020%H\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/pos/AddTransactionUseCase;", "", "saleRepository", "Lcom/bits/bee/bpmc/domain/repository/SaleRepository;", "saledRepository", "Lcom/bits/bee/bpmc/domain/repository/SaledRepository;", "getActiveBranchUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveBranchUseCase;", "getActiveCashierUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveCashierUseCase;", "getActiveOperatorUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveOperatorUseCase;", "getActivePossesUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActivePossesUseCase;", "getDefaultCrcUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetDefaultCrcUseCase;", "addCashAUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/AddCashAUseCase;", "addTotalPossesUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/AddTotalPossesUseCase;", "addPaymentUseCase", "Lcom/bits/bee/bpmc/domain/usecase/pos/AddPaymentUseCase;", "defDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/bits/bee/bpmc/domain/repository/SaleRepository;Lcom/bits/bee/bpmc/domain/repository/SaledRepository;Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveBranchUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveCashierUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveOperatorUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/GetActivePossesUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/GetDefaultCrcUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/AddCashAUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/AddTotalPossesUseCase;Lcom/bits/bee/bpmc/domain/usecase/pos/AddPaymentUseCase;Lkotlinx/coroutines/CoroutineDispatcher;)V", "invoke", "", "sale", "Lcom/bits/bee/bpmc/domain/model/Sale;", "saledList", "", "Lcom/bits/bee/bpmc/domain/model/Saled;", "paymentAmt", "Ljava/math/BigDecimal;", "pmtd", "Lcom/bits/bee/bpmc/domain/model/Pmtd;", "trackNo", "", "cardNo", "note", "(Lcom/bits/bee/bpmc/domain/model/Sale;Ljava/util/List;Ljava/math/BigDecimal;Lcom/bits/bee/bpmc/domain/model/Pmtd;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AddTransactionUseCase {
    private final com.bits.bee.bpmc.domain.repository.SaleRepository saleRepository = null;
    private final com.bits.bee.bpmc.domain.repository.SaledRepository saledRepository = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase getActiveBranchUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase getActiveCashierUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetActiveOperatorUseCase getActiveOperatorUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase getActivePossesUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetDefaultCrcUseCase getDefaultCrcUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.AddCashAUseCase addCashAUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.AddTotalPossesUseCase addTotalPossesUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.pos.AddPaymentUseCase addPaymentUseCase = null;
    private final kotlinx.coroutines.CoroutineDispatcher defDispatcher = null;
    
    @javax.inject.Inject()
    public AddTransactionUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.SaleRepository saleRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.SaledRepository saledRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase getActiveBranchUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase getActiveCashierUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveOperatorUseCase getActiveOperatorUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase getActivePossesUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetDefaultCrcUseCase getDefaultCrcUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.AddCashAUseCase addCashAUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.AddTotalPossesUseCase addTotalPossesUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.pos.AddPaymentUseCase addPaymentUseCase, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale, @org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Saled> saledList, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal paymentAmt, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Pmtd pmtd, @org.jetbrains.annotations.NotNull()
    java.lang.String trackNo, @org.jetbrains.annotations.NotNull()
    java.lang.String cardNo, @org.jetbrains.annotations.NotNull()
    java.lang.String note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}