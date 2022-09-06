package com.bits.bee.bpmc.data.data_source.remote.apiservices;

import java.lang.System;

/**
 * Created by aldi on 30/03/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'\u00a8\u0006\u0006"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/CityApiService;", "", "getCityList", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/ApiResponse;", "Lcom/bits/bee/bpmc/data/data_source/remote/response/CityResponse;", "app_debug"})
public abstract interface CityApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v1/city")
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.ApiResponse<com.bits.bee.bpmc.data.data_source.remote.response.CityResponse>> getCityList();
}