package com.bits.bee.bpmc.domain.usecase.common;

import java.lang.System;

/**
 * Created by aldi on 20/07/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JA\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/common/AddCashAUseCase;", "", "cashARepository", "Lcom/bits/bee/bpmc/domain/repository/CashARepository;", "(Lcom/bits/bee/bpmc/domain/repository/CashARepository;)V", "invoke", "", "refId", "", "refType", "", "cashId", "", "userId", "cashierId", "amt", "Ljava/math/BigDecimal;", "(JLjava/lang/String;IIILjava/math/BigDecimal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AddCashAUseCase {
    private final com.bits.bee.bpmc.domain.repository.CashARepository cashARepository = null;
    
    @javax.inject.Inject()
    public AddCashAUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.CashARepository cashARepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(long refId, @org.jetbrains.annotations.NotNull()
    java.lang.String refType, int cashId, int userId, int cashierId, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal amt, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}