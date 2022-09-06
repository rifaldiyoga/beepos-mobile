package com.bits.bee.bpmc.domain.usecase.printer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJU\u0010(\u001a6\u00122\u00120\u0012,\u0012*\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00180\u001ej\u0014\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0018` 0*0)2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010&2\u0006\u0010-\u001a\u00020.H\u0086\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cRB\u0010\u001d\u001a*\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00180\u001ej\u0014\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0018` X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020\'\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/printer/GetListKitchenUseCase;", "", "printerKitchenDRepo", "Lcom/bits/bee/bpmc/domain/repository/PrinterKitchenDRepository;", "kitchenRepo", "Lcom/bits/bee/bpmc/domain/repository/KitchenRepository;", "itemGoupRepo", "Lcom/bits/bee/bpmc/domain/repository/ItemGroupRepository;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/bits/bee/bpmc/domain/repository/PrinterKitchenDRepository;Lcom/bits/bee/bpmc/domain/repository/KitchenRepository;Lcom/bits/bee/bpmc/domain/repository/ItemGroupRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "itemgrp", "Lcom/bits/bee/bpmc/domain/model/ItemGroup;", "getItemgrp", "()Lcom/bits/bee/bpmc/domain/model/ItemGroup;", "setItemgrp", "(Lcom/bits/bee/bpmc/domain/model/ItemGroup;)V", "kitchen", "Lcom/bits/bee/bpmc/domain/model/Kitchen;", "getKitchen", "()Lcom/bits/bee/bpmc/domain/model/Kitchen;", "setKitchen", "(Lcom/bits/bee/bpmc/domain/model/Kitchen;)V", "listKitchen", "", "getListKitchen", "()Ljava/util/List;", "setListKitchen", "(Ljava/util/List;)V", "listhashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getListhashMap", "()Ljava/util/HashMap;", "setListhashMap", "(Ljava/util/HashMap;)V", "mListPrinterKitchenD", "", "Lcom/bits/bee/bpmc/domain/model/PrinterKitchenD;", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "mList", "Lcom/bits/bee/bpmc/domain/model/PrinterKitchen;", "data_kitchen", "", "app_debug"})
public final class GetListKitchenUseCase {
    private final com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository printerKitchenDRepo = null;
    private final com.bits.bee.bpmc.domain.repository.KitchenRepository kitchenRepo = null;
    private final com.bits.bee.bpmc.domain.repository.ItemGroupRepository itemGoupRepo = null;
    private final kotlinx.coroutines.CoroutineDispatcher defaultDispatcher = null;
    private java.util.List<com.bits.bee.bpmc.domain.model.PrinterKitchenD> mListPrinterKitchenD;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.bits.bee.bpmc.domain.model.Kitchen> listKitchen;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.Kitchen kitchen;
    @org.jetbrains.annotations.Nullable()
    private com.bits.bee.bpmc.domain.model.ItemGroup itemgrp;
    @org.jetbrains.annotations.NotNull()
    private java.util.HashMap<java.lang.Integer, java.util.List<com.bits.bee.bpmc.domain.model.Kitchen>> listhashMap;
    
    @javax.inject.Inject()
    public GetListKitchenUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.PrinterKitchenDRepository printerKitchenDRepo, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.KitchenRepository kitchenRepo, @org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.ItemGroupRepository itemGoupRepo, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineDispatcher defaultDispatcher) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.bits.bee.bpmc.domain.model.Kitchen> getListKitchen() {
        return null;
    }
    
    public final void setListKitchen(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Kitchen> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.Kitchen getKitchen() {
        return null;
    }
    
    public final void setKitchen(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.Kitchen p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.bits.bee.bpmc.domain.model.ItemGroup getItemgrp() {
        return null;
    }
    
    public final void setItemgrp(@org.jetbrains.annotations.Nullable()
    com.bits.bee.bpmc.domain.model.ItemGroup p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.HashMap<java.lang.Integer, java.util.List<com.bits.bee.bpmc.domain.model.Kitchen>> getListhashMap() {
        return null;
    }
    
    public final void setListhashMap(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.Integer, java.util.List<com.bits.bee.bpmc.domain.model.Kitchen>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.HashMap<java.lang.Integer, java.util.List<com.bits.bee.bpmc.domain.model.Kitchen>>>> invoke(@org.jetbrains.annotations.Nullable()
    java.util.List<com.bits.bee.bpmc.domain.model.PrinterKitchen> mList, boolean data_kitchen) {
        return null;
    }
}