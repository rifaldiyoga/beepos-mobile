package com.bits.bee.bpmc.domain.usecase.download;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/download/GetLatestDistrictUseCase;", "", "districtRepository", "Lcom/bits/bee/bpmc/domain/repository/DistrictRepository;", "(Lcom/bits/bee/bpmc/domain/repository/DistrictRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "Lcom/bits/bee/bpmc/data/data_source/remote/response/DistrictResponse;", "page", "", "app_debug"})
public final class GetLatestDistrictUseCase {
    private final com.bits.bee.bpmc.domain.repository.DistrictRepository districtRepository = null;
    
    @javax.inject.Inject()
    public GetLatestDistrictUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.DistrictRepository districtRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.data.data_source.remote.response.DistrictResponse>> invoke(int page) {
        return null;
    }
}