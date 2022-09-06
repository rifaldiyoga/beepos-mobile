package com.bits.bee.bpmc.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u0007H%J\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007J\u001b\u0010\f\u001a\u00028\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0003\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/bits/bee/bpmc/utils/NetworkBoundResource;", "RequestObject", "", "isNextPage", "", "(Z)V", "result", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "createCall", "Lcom/bits/bee/bpmc/utils/ApiResponse;", "getAsFlow", "processResponse", "response", "Lcom/bits/bee/bpmc/utils/ApiSuccessResponse;", "(Lcom/bits/bee/bpmc/utils/ApiSuccessResponse;)Ljava/lang/Object;", "app_debug"})
public abstract class NetworkBoundResource<RequestObject extends java.lang.Object> {
    private final boolean isNextPage = false;
    private final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<RequestObject>> result = null;
    
    @androidx.annotation.MainThread()
    public NetworkBoundResource() {
        super();
    }
    
    @androidx.annotation.MainThread()
    public NetworkBoundResource(boolean isNextPage) {
        super();
    }
    
    @androidx.annotation.WorkerThread()
    private final RequestObject processResponse(com.bits.bee.bpmc.utils.ApiSuccessResponse<RequestObject> response) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<RequestObject>> getAsFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.MainThread()
    protected abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.ApiResponse<RequestObject>> createCall();
}