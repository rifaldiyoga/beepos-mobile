package com.bits.bee.bpmc.domain.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001f\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/bits/bee/bpmc/domain/repository/ProvinceRepository;", "", "getLatestProvince", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "Lcom/bits/bee/bpmc/data/data_source/remote/response/ProvinceResponse;", "page", "", "insertBulkProvince", "", "list", "", "Lcom/bits/bee/bpmc/data/data_source/local/model/ProvinceEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ProvinceRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertBulkProvince(@org.jetbrains.annotations.NotNull()
    java.util.List<com.bits.bee.bpmc.data.data_source.local.model.ProvinceEntity> list, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.data.data_source.remote.response.ProvinceResponse>> getLatestProvince(int page);
}