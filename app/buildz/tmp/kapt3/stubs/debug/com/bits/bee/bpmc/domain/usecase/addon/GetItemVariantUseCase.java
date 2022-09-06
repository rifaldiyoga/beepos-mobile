package com.bits.bee.bpmc.domain.usecase.addon;

import java.lang.System;

/**
 * Created by aldi on 15/08/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/addon/GetItemVariantUseCase;", "", "variantRepository", "Lcom/bits/bee/bpmc/domain/repository/VariantRepository;", "getPriceItemUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetPriceItemUseCase;", "(Lcom/bits/bee/bpmc/domain/repository/VariantRepository;Lcom/bits/bee/bpmc/domain/usecase/common/GetPriceItemUseCase;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/domain/model/VariantWithItem;", "variantId", "", "priceLvlId", "bp", "Lcom/bits/bee/bpmc/domain/model/Bp;", "app_debug"})
public final class GetItemVariantUseCase {
    private final com.bits.bee.bpmc.domain.repository.VariantRepository variantRepository = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetPriceItemUseCase getPriceItemUseCase = null;
    
    @javax.inject.Inject()
    public GetItemVariantUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.VariantRepository variantRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetPriceItemUseCase getPriceItemUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.domain.model.VariantWithItem> invoke(int variantId, int priceLvlId, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Bp bp) {
        return null;
    }
}