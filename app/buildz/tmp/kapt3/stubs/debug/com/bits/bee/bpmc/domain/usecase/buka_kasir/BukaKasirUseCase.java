package com.bits.bee.bpmc.domain.usecase.buka_kasir;

import java.lang.System;

/**
 * Created by aldi on 10/06/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ1\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/buka_kasir/BukaKasirUseCase;", "", "possesRepository", "Lcom/bits/bee/bpmc/domain/repository/PossesRepository;", "cashRepository", "Lcom/bits/bee/bpmc/domain/repository/CashRepository;", "addCashAUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/AddCashAUseCase;", "addCstrUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/AddCstrUseCase;", "cashARepository", "Lcom/bits/bee/bpmc/domain/repository/CashARepository;", "(Lcom/bits/bee/bpmc/domain/repository/PossesRepository;Lcom/bits/bee/bpmc/domain/repository/CashRepository;Lcom/bits/bee/bpmc/domain/usecase/common/AddCashAUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/AddCstrUseCase;Lcom/bits/bee/bpmc/domain/repository/CashARepository;)V", "mCash", "Lcom/bits/bee/bpmc/domain/model/Cash;", "mCstr", "Lcom/bits/bee/bpmc/domain/model/Cstr;", "mListCasha", "", "Lcom/bits/bee/bpmc/domain/model/CashA;", "mPosses", "Lcom/bits/bee/bpmc/domain/model/Posses;", "mShift", "", "invoke", "", "modal", "Ljava/math/BigDecimal;", "shift", "branch", "Lcom/bits/bee/bpmc/domain/model/Branch;", "cashier", "Lcom/bits/bee/bpmc/domain/model/Cashier;", "(Ljava/math/BigDecimal;ILcom/bits/bee/bpmc/domain/model/Branch;Lcom/bits/bee/bpmc/domain/model/Cashier;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class BukaKasirUseCase {
    private final com.bits.bee.bpmc.domain.repository.PossesRepository possesRepository = null;
    private final com.bits.bee.bpmc.domain.repository.CashRepository cashRepository = null;
    private final com.bits.bee.bpmc.domain.usecase.common.AddCashAUseCase addCashAUseCase = null;
    private final com.bits.bee.bpmc.domain.usecase.common.AddCstrUseCase addCstrUseCase = null;
    private final com.bits.bee.bpmc.domain.repository.CashARepository cashARepository = null;
    private com.bits.bee.bpmc.domain.model.Cash mCash;
    private com.bits.bee.bpmc.domain.model.Posses mPosses;
    private com.bits.bee.bpmc.domain.model.Cstr mCstr;
    private java.util.List<com.bits.bee.bpmc.domain.model.CashA> mListCasha;
    private int mShift = 0;
    
    @javax.inject.Inject()
    public BukaKasirUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.PossesRepository possesRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.CashRepository cashRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.AddCashAUseCase addCashAUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.AddCstrUseCase addCstrUseCase, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.CashARepository cashARepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal modal, int shift, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Branch branch, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Cashier cashier, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}