package com.bits.bee.bpmc.utils;

import java.lang.System;

/**
 * Created by aldi on 02/03/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u0004*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0003\u0082\u0001\u0005\u0005\u0006\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/bits/bee/bpmc/utils/ApiResponse;", "T", "", "()V", "Companion", "Lcom/bits/bee/bpmc/utils/ApiEmptyResponse;", "Lcom/bits/bee/bpmc/utils/ApiErrorResponse;", "Lcom/bits/bee/bpmc/utils/ApiSuccessResponse;", "Lcom/bits/bee/bpmc/utils/ApiTimeoutResponse;", "Lcom/bits/bee/bpmc/utils/ApiUnAuthorizedResponse;", "app_debug"})
public abstract class ApiResponse<T extends java.lang.Object> {
    @org.jetbrains.annotations.NotNull()
    public static final com.bits.bee.bpmc.utils.ApiResponse.Companion Companion = null;
    
    private ApiResponse() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J \u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t\u00a8\u0006\n"}, d2 = {"Lcom/bits/bee/bpmc/utils/ApiResponse$Companion;", "", "()V", "create", "Lcom/bits/bee/bpmc/utils/ApiResponse;", "T", "error", "", "response", "Lretrofit2/Response;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final <T extends java.lang.Object>com.bits.bee.bpmc.utils.ApiResponse<T> create(@org.jetbrains.annotations.NotNull()
        java.lang.Throwable error) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final <T extends java.lang.Object>com.bits.bee.bpmc.utils.ApiResponse<T> create(@org.jetbrains.annotations.NotNull()
        retrofit2.Response<T> response) {
            return null;
        }
    }
}