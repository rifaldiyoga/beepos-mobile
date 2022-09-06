package com.bits.bee.bpmc.domain.usecase.pos;

import java.lang.System;

/**
 * Created by aldi on 12/05/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJK\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/pos/GetActiveItemUseCase;", "", "itemRepository", "Lcom/bits/bee/bpmc/domain/repository/ItemRepository;", "itemAddOnRepository", "Lcom/bits/bee/bpmc/domain/repository/ItemAddOnRepository;", "itemVariantRepository", "Lcom/bits/bee/bpmc/domain/repository/ItemVariantRepository;", "getPriceItemUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetPriceItemUseCase;", "(Lcom/bits/bee/bpmc/domain/repository/ItemRepository;Lcom/bits/bee/bpmc/domain/repository/ItemAddOnRepository;Lcom/bits/bee/bpmc/domain/repository/ItemVariantRepository;Lcom/bits/bee/bpmc/domain/usecase/common/GetPriceItemUseCase;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/bits/bee/bpmc/domain/model/Item;", "itemGrpId", "", "priceLvlId", "bp", "Lcom/bits/bee/bpmc/domain/model/Bp;", "query", "", "usePid", "", "(IILcom/bits/bee/bpmc/domain/model/Bp;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GetActiveItemUseCase {
    private final com.bits.bee.bpmc.domain.repository.ItemRepository itemRepository = null;
    private final com.bits.bee.bpmc.domain.repository.ItemAddOnRepository itemAddOnRepository = null;
    private final com.bits.bee.bpmc.domain.repository.ItemVariantRepository itemVariantRepository = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetPriceItemUseCase getPriceItemUseCase = null;
    
    @javax.inject.Inject()
    public GetActiveItemUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.ItemRepository itemRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.ItemAddOnRepository itemAddOnRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.ItemVariantRepository itemVariantRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetPriceItemUseCase getPriceItemUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(int itemGrpId, int priceLvlId, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Bp bp, @org.jetbrains.annotations.NotNull()
    java.lang.String query, boolean usePid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.bits.bee.bpmc.domain.model.Item>>> continuation) {
        return null;
    }
}