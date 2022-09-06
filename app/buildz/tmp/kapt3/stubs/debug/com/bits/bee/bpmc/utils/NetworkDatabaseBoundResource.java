package com.bits.bee.bpmc.utils;

import java.lang.System;

/**
 * Created by aldi on 02/03/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\bH\u00a5@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\bJ\u0013\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u00a4@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001b\u0010\u000f\u001a\u00028\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0003\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0001H\u00a4@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00018\u0000H$\u00a2\u0006\u0002\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/bits/bee/bpmc/utils/NetworkDatabaseBoundResource;", "ResultType", "RequestType", "", "isNextPage", "", "(Z)V", "result", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/Resource;", "createCall", "Lcom/bits/bee/bpmc/utils/ApiResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAsFlow", "loadFormDB", "processResponse", "response", "Lcom/bits/bee/bpmc/utils/ApiSuccessResponse;", "(Lcom/bits/bee/bpmc/utils/ApiSuccessResponse;)Ljava/lang/Object;", "saveCallResult", "", "data", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldFetch", "(Ljava/lang/Object;)Z", "app_debug"})
public abstract class NetworkDatabaseBoundResource<ResultType extends java.lang.Object, RequestType extends java.lang.Object> {
    private final boolean isNextPage = false;
    private final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<ResultType>> result = null;
    
    @androidx.annotation.MainThread()
    public NetworkDatabaseBoundResource() {
        super();
    }
    
    @androidx.annotation.MainThread()
    public NetworkDatabaseBoundResource(boolean isNextPage) {
        super();
    }
    
    @androidx.annotation.WorkerThread()
    private final RequestType processResponse(com.bits.bee.bpmc.utils.ApiSuccessResponse<RequestType> response) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.Resource<ResultType>> getAsFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    protected abstract java.lang.Object loadFormDB(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super ResultType> continuation);
    
    protected abstract boolean shouldFetch(@org.jetbrains.annotations.Nullable()
    ResultType data);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.MainThread()
    protected abstract java.lang.Object createCall(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.bits.bee.bpmc.utils.ApiResponse<RequestType>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    protected abstract java.lang.Object saveCallResult(RequestType data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}