package com.bits.bee.bpmc.domain.repository;

import java.lang.System;

/**
 * Created by aldi on 20/07/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/domain/repository/SaleCrcvRepository;", "", "addSaleCrcv", "", "saleCrcv", "Lcom/bits/bee/bpmc/domain/model/SaleCrcv;", "(Lcom/bits/bee/bpmc/domain/model/SaleCrcv;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface SaleCrcvRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addSaleCrcv(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.SaleCrcv saleCrcv, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}