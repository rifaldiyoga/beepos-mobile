package com.bits.bee.bpmc.domain.repository;

import java.lang.System;

/**
 * Created by aldi on 30/06/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\t0\u0003H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/bits/bee/bpmc/domain/repository/ItemDummyRepository;", "", "addItemDummy", "Lkotlinx/coroutines/flow/Flow;", "", "itemDummy", "Lcom/bits/bee/bpmc/domain/model/ItemDummy;", "(Lcom/bits/bee/bpmc/domain/model/ItemDummy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getItemDummyList", "", "app_debug"})
public abstract interface ItemDummyRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.bits.bee.bpmc.domain.model.ItemDummy>> getItemDummyList();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addItemDummy(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.ItemDummy itemDummy, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<java.lang.Long>> continuation);
}