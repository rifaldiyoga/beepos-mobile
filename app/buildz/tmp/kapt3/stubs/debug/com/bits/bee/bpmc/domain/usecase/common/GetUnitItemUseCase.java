package com.bits.bee.bpmc.domain.usecase.common;

import java.lang.System;

/**
 * Created by aldi on 05/08/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/common/GetUnitItemUseCase;", "", "unitRepository", "Lcom/bits/bee/bpmc/domain/repository/UnitRepository;", "(Lcom/bits/bee/bpmc/domain/repository/UnitRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/bits/bee/bpmc/domain/model/Unit;", "itemId", "", "app_debug"})
public final class GetUnitItemUseCase {
    private final com.bits.bee.bpmc.domain.repository.UnitRepository unitRepository = null;
    
    @javax.inject.Inject()
    public GetUnitItemUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.UnitRepository unitRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.bits.bee.bpmc.domain.model.Unit>> invoke(int itemId) {
        return null;
    }
}