package com.bits.bee.bpmc.domain.usecase.addon;

import java.lang.System;

/**
 * Created by aldi on 15/08/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ5\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/addon/GetSelectionAddOnUseCase;", "", "selectionRepository", "Lcom/bits/bee/bpmc/domain/repository/SelectionRepository;", "itemRepository", "Lcom/bits/bee/bpmc/domain/repository/ItemRepository;", "getPriceItemUseCase", "Lcom/bits/bee/bpmc/domain/usecase/common/GetPriceItemUseCase;", "(Lcom/bits/bee/bpmc/domain/repository/SelectionRepository;Lcom/bits/bee/bpmc/domain/repository/ItemRepository;Lcom/bits/bee/bpmc/domain/usecase/common/GetPriceItemUseCase;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/bits/bee/bpmc/domain/model/SelectionWithItem;", "item", "Lcom/bits/bee/bpmc/domain/model/Item;", "priceLvlId", "", "bp", "Lcom/bits/bee/bpmc/domain/model/Bp;", "(Lcom/bits/bee/bpmc/domain/model/Item;ILcom/bits/bee/bpmc/domain/model/Bp;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GetSelectionAddOnUseCase {
    private final com.bits.bee.bpmc.domain.repository.SelectionRepository selectionRepository = null;
    private final com.bits.bee.bpmc.domain.repository.ItemRepository itemRepository = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetPriceItemUseCase getPriceItemUseCase = null;
    
    @javax.inject.Inject()
    public GetSelectionAddOnUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.SelectionRepository selectionRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.ItemRepository itemRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetPriceItemUseCase getPriceItemUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Item item, int priceLvlId, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Bp bp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.bits.bee.bpmc.domain.model.SelectionWithItem>>> continuation) {
        return null;
    }
}