package com.bits.bee.bpmc.domain.usecase.download;

import java.lang.System;

/**
 * Created by aldi on 14/04/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/download/GetLatestEdcUseCase;", "", "channelRepository", "Lcom/bits/bee/bpmc/domain/repository/EdcRepository;", "(Lcom/bits/bee/bpmc/domain/repository/EdcRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "", "Lcom/bits/bee/bpmc/domain/model/Edc;", "app_debug"})
public final class GetLatestEdcUseCase {
    private final com.bits.bee.bpmc.domain.repository.EdcRepository channelRepository = null;
    
    @javax.inject.Inject()
    public GetLatestEdcUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.EdcRepository channelRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<java.util.List<com.bits.bee.bpmc.domain.model.Edc>>> invoke() {
        return null;
    }
}