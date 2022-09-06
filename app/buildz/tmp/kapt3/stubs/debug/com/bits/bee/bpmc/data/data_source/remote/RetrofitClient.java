package com.bits.bee.bpmc.data.data_source.remote;

import java.lang.System;

/**
 * Created by aldi on 25/02/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/RetrofitClient;", "", "()V", "retrofit", "Lretrofit2/Retrofit;", "getClientApi", "getClientProvision", "AddHeaderInterceptor", "app_debug"})
public final class RetrofitClient {
    private retrofit2.Retrofit retrofit;
    
    public RetrofitClient() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final retrofit2.Retrofit getClientProvision() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final retrofit2.Retrofit getClientApi() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/RetrofitClient$AddHeaderInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_debug"})
    static final class AddHeaderInterceptor implements okhttp3.Interceptor {
        
        public AddHeaderInterceptor() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
        @java.lang.Override()
        public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull()
        okhttp3.Interceptor.Chain chain) throws java.io.IOException {
            return null;
        }
    }
}