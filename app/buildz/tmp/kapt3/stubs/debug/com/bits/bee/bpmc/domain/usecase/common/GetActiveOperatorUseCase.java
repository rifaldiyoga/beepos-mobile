package com.bits.bee.bpmc.domain.usecase.common;

import java.lang.System;

/**
 * Created by aldi on 23/06/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/bits/bee/bpmc/domain/usecase/common/GetActiveOperatorUseCase;", "", "userRepository", "Lcom/bits/bee/bpmc/domain/repository/UserRepository;", "(Lcom/bits/bee/bpmc/domain/repository/UserRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/domain/model/User;", "app_debug"})
public final class GetActiveOperatorUseCase {
    private final com.bits.bee.bpmc.domain.repository.UserRepository userRepository = null;
    
    @javax.inject.Inject()
    public GetActiveOperatorUseCase(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.repository.UserRepository userRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.domain.model.User> invoke() {
        return null;
    }
}