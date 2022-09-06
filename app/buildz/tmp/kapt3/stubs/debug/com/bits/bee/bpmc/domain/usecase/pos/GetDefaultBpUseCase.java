package com.bits.bee.bpmc.domain.usecase.pos;

import java.lang.System;

/**
 * Created by aldi on 26/04/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/pos/GetDefaultBpUseCase;", "", "bpRepository", "Lcom/bits/bee/bpmc/domain/repository/BpRepository;", "getActiveBranchUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveBranchUseCase;", "(Lcom/bits/bee/bpmc/domain/repository/BpRepository;Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveBranchUseCase;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/domain/model/Bp;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GetDefaultBpUseCase {
    private final com.bits.bee.bpmc.domain.repository.BpRepository bpRepository = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase getActiveBranchUseCase = null;
    
    @javax.inject.Inject()
    public GetDefaultBpUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.BpRepository bpRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase getActiveBranchUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.domain.model.Bp>> continuation) {
        return null;
    }
}