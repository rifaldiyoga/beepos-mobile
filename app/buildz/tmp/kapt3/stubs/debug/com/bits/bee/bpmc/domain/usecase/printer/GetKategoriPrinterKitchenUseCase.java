package com.bits.bee.bpmc.domain.usecase.printer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/printer/GetKategoriPrinterKitchenUseCase;", "", "kitchenRepo", "Lcom/bits/bee/bpmc/domain/repository/KitchenRepository;", "itemGrpRepo", "Lcom/bits/bee/bpmc/domain/repository/ItemGroupRepository;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/bits/bee/bpmc/domain/repository/KitchenRepository;Lcom/bits/bee/bpmc/domain/repository/ItemGroupRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "itmGrpList", "", "Lcom/bits/bee/bpmc/domain/model/ItemGroup;", "mutListKitchen", "", "Lcom/bits/bee/bpmc/domain/model/Kitchen;", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "data_kitchen", "", "app_debug"})
public final class GetKategoriPrinterKitchenUseCase {
    private final com.bits.bee.bpmc.domain.repository.KitchenRepository kitchenRepo = null;
    private final com.bits.bee.bpmc.domain.repository.ItemGroupRepository itemGrpRepo = null;
    private final kotlinx.coroutines.CoroutineDispatcher defaultDispatcher = null;
    private java.util.List<com.bits.bee.bpmc.domain.model.Kitchen> mutListKitchen;
    private java.util.List<com.bits.bee.bpmc.domain.model.ItemGroup> itmGrpList;
    
    @javax.inject.Inject()
    public GetKategoriPrinterKitchenUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.KitchenRepository kitchenRepo, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.ItemGroupRepository itemGrpRepo, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Kitchen>>> invoke(boolean data_kitchen) {
        return null;
    }
}