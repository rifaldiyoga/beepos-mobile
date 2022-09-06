package com.bits.bee.bpmc.domain.usecase.pos;

import java.lang.System;

/**
 * Created by aldi on 04/08/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J+\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b2\u0006\u0010\f\u001a\u00020\rH\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/pos/GetPidByItemUseCase;", "", "stockRepository", "Lcom/bits/bee/bpmc/domain/repository/StockRepository;", "getActiveWhUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveWhUseCase;", "(Lcom/bits/bee/bpmc/domain/repository/StockRepository;Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveWhUseCase;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "", "Lcom/bits/bee/bpmc/domain/model/Stock;", "item", "Lcom/bits/bee/bpmc/domain/model/Item;", "(Lcom/bits/bee/bpmc/domain/model/Item;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GetPidByItemUseCase {
    private final com.bits.bee.bpmc.domain.repository.StockRepository stockRepository = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetActiveWhUseCase getActiveWhUseCase = null;
    
    @javax.inject.Inject()
    public GetPidByItemUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.StockRepository stockRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveWhUseCase getActiveWhUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Item item, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.bits.bee.bpmc.utils.Resource<? extends java.util.List<com.bits.bee.bpmc.domain.model.Stock>>>> continuation) {
        return null;
    }
}