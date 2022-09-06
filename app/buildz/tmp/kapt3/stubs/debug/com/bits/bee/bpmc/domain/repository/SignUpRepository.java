package com.bits.bee.bpmc.domain.repository;

import java.lang.System;

/**
 * Created by aldi on 30/08/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/bits/bee/bpmc/domain/repository/SignUpRepository;", "", "postSignUp", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "Lcom/bits/bee/bpmc/data/data_source/remote/response/SignUpResponse;", "signUp", "Lcom/bits/bee/bpmc/domain/model/SignUp;", "app_debug"})
public abstract interface SignUpRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<com.bits.bee.bpmc.data.data_source.remote.response.SignUpResponse>> postSignUp(@org.jetbrains.annotations.NotNull()
    com.bits.bee.bpmc.domain.model.SignUp signUp);
}