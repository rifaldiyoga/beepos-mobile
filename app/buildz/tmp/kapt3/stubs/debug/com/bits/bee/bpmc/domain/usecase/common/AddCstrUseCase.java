package com.bits.bee.bpmc.domain.usecase.common;

import java.lang.System;

/**
 * Created by aldi on 20/07/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J9\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/common/AddCstrUseCase;", "", "cstrRepository", "Lcom/bits/bee/bpmc/domain/repository/CstrRepository;", "(Lcom/bits/bee/bpmc/domain/repository/CstrRepository;)V", "invoke", "", "refNo", "", "refType", "amt", "Ljava/math/BigDecimal;", "branch", "Lcom/bits/bee/bpmc/domain/model/Branch;", "cashier", "Lcom/bits/bee/bpmc/domain/model/Cashier;", "(Ljava/lang/String;Ljava/lang/String;Ljava/math/BigDecimal;Lcom/bits/bee/bpmc/domain/model/Branch;Lcom/bits/bee/bpmc/domain/model/Cashier;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AddCstrUseCase {
    private final com.bits.bee.bpmc.domain.repository.CstrRepository cstrRepository = null;
    
    @javax.inject.Inject()
    public AddCstrUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.CstrRepository cstrRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    java.lang.String refNo, @org.jetbrains.annotations.NotNull()
    java.lang.String refType, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal amt, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Branch branch, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Cashier cashier, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}