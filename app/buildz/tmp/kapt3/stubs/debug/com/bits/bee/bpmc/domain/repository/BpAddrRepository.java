package com.bits.bee.bpmc.domain.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/bits/bee/bpmc/domain/repository/BpAddrRepository;", "", "addUpdateBpAddr", "", "bpaddr", "Lcom/bits/bee/bpmc/data/data_source/local/model/BpAddrEntity;", "(Lcom/bits/bee/bpmc/data/data_source/local/model/BpAddrEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBpAddrByBp", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "Lcom/bits/bee/bpmc/domain/model/BpAddr;", "id", "", "app_debug"})
public abstract interface BpAddrRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addUpdateBpAddr(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.data.data_source.local.model.BpAddrEntity bpaddr, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.domain.model.BpAddr>> getBpAddrByBp(int id);
}