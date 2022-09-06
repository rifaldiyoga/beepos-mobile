package com.bits.bee.bpmc.domain.usecase.pos;

import java.lang.System;

/**
 * Created by aldi on 20/07/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006JC\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/pos/AddPaymentUseCase;", "", "saleCrcvRepository", "Lcom/bits/bee/bpmc/domain/repository/SaleCrcvRepository;", "getActiveCashierUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveCashierUseCase;", "(Lcom/bits/bee/bpmc/domain/repository/SaleCrcvRepository;Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveCashierUseCase;)V", "invoke", "", "sale", "Lcom/bits/bee/bpmc/domain/model/Sale;", "pmtd", "Lcom/bits/bee/bpmc/domain/model/Pmtd;", "trackNo", "", "cardNo", "note", "(Lcom/bits/bee/bpmc/domain/model/Sale;Lcom/bits/bee/bpmc/domain/model/Pmtd;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AddPaymentUseCase {
    private final com.bits.bee.bpmc.domain.repository.SaleCrcvRepository saleCrcvRepository = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase getActiveCashierUseCase = null;
    
    @javax.inject.Inject()
    public AddPaymentUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.SaleCrcvRepository saleCrcvRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase getActiveCashierUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Sale sale, @org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Pmtd pmtd, @org.jetbrains.annotations.NotNull()
    java.lang.String trackNo, @org.jetbrains.annotations.NotNull()
    java.lang.String cardNo, @org.jetbrains.annotations.NotNull()
    java.lang.String note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}