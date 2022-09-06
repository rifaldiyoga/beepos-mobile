package com.bits.bee.bpmc.domain.repository;

import java.lang.System;

/**
 * Created by aldi on 30/06/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H&J\u001a\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u00060\u0003H&\u00a8\u0006\b"}, d2 = {"Lcom/bits/bee/bpmc/domain/repository/CrcRepository;", "", "getDefaultCrc", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/domain/model/Crc;", "getLatestCrc", "Lcom/bits/bee/bpmc/utils/Resource;", "", "app_debug"})
public abstract interface CrcRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Crc>>> getLatestCrc();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.domain.model.Crc> getDefaultCrc();
}