package com.bits.bee.bpmc.domain.repository;

import java.lang.System;

/**
 * Created by aldi on 20/05/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\t2\u0006\u0010\u000b\u001a\u00020\fH&J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\t2\u0006\u0010\u000e\u001a\u00020\fH&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/bits/bee/bpmc/domain/repository/SaledRepository;", "", "addSaled", "", "saledList", "", "Lcom/bits/bee/bpmc/domain/model/Saled;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRankItem", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/domain/model/RankItem;", "possesId", "", "getSaledList", "saleId", "app_debug"})
public abstract interface SaledRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addSaled(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.domain.model.Saled> saledList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.bits.bee.bpmc.domain.model.Saled>> getSaledList(int saleId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.bits.bee.bpmc.domain.model.RankItem>> getRankItem(int possesId);
}