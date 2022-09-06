package com.bits.bee.bpmc.domain.usecase.common;

import java.lang.System;

/**
 * Created by aldi on 22/08/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ)\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086B\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/common/GetPriceItemUseCase;", "", "priceRepository", "Lcom/bits/bee/bpmc/domain/repository/PriceRepository;", "itemSaleTaxRepository", "Lcom/bits/bee/bpmc/domain/repository/ItemSaleTaxRepository;", "getDefaultCrc", "Lcom/bits/bee/bpmc/domain/usecase/common/GetDefaultCrcUseCase;", "getUnitItemUse", "Lcom/bits/bee/bpmc/domain/usecase/common/GetUnitItemUseCase;", "(Lcom/bits/bee/bpmc/domain/repository/PriceRepository;Lcom/bits/bee/bpmc/domain/repository/ItemSaleTaxRepository;Lcom/bits/bee/bpmc/domain/usecase/common/GetDefaultCrcUseCase;Lcom/bits/bee/bpmc/domain/usecase/common/GetUnitItemUseCase;)V", "invoke", "Lcom/bits/bee/bpmc/domain/model/Item;", "item", "priceLvlId", "", "bp", "Lcom/bits/bee/bpmc/domain/model/Bp;", "(Lcom/bits/bee/bpmc/domain/model/Item;ILcom/bits/bee/bpmc/domain/model/Bp;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GetPriceItemUseCase {
    private final com.bits.bee.bpmc.domain.repository.PriceRepository priceRepository = null;
    private final com.bits.bee.bpmc.domain.repository.ItemSaleTaxRepository itemSaleTaxRepository = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetDefaultCrcUseCase getDefaultCrc = null;
    private final com.bits.bee.bpmc.domain.usecase.common.GetUnitItemUseCase getUnitItemUse = null;
    
    @javax.inject.Inject()
    public GetPriceItemUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.PriceRepository priceRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.ItemSaleTaxRepository itemSaleTaxRepository, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetDefaultCrcUseCase getDefaultCrc, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.usecase.common.GetUnitItemUseCase getUnitItemUse) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Item item, int priceLvlId, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.Bp bp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.bits.bee.bpmc.domain.model.Item> continuation) {
        return null;
    }
}