package com.bits.bee.bpmc.domain.repository;

import java.lang.System;

/**
 * Created by aldi on 30/06/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00040\u000b0\u0003H&\u00a8\u0006\r"}, d2 = {"Lcom/bits/bee/bpmc/domain/repository/EdcSurcRepository;", "", "getEdcSurcActive", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/bits/bee/bpmc/domain/model/EdcSurcAndCcType;", "edcId", "", "type", "", "getLatestEdcSurc", "Lcom/bits/bee/bpmc/utils/Resource;", "Lcom/bits/bee/bpmc/domain/model/EdcSurc;", "app_debug"})
public abstract interface EdcSurcRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.EdcSurc>>> getLatestEdcSurc();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.bits.bee.bpmc.domain.model.EdcSurcAndCcType>> getEdcSurcActive(int edcId, @org.jetbrains.annotations.NotNull()
    java.lang.String type);
}