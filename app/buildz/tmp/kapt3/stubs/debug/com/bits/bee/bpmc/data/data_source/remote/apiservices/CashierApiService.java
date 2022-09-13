package com.bits.bee.bpmc.data.data_source.remote.apiservices;

import java.lang.System;

/**
 * Created by aldi on 17/03/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'\u00a8\u0006\b"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/CashierApiService;", "", "getCashierList", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/ApiResponse;", "Lcom/bits/bee/bpmc/data/data_source/remote/response/CashierResponse;", "branchId", "", "app_debug"})
public abstract interface CashierApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v1/cashier")
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.ApiResponse<com.bits.bee.bpmc.data.data_source.remote.response.CashierResponse>> getCashierList(@retrofit2.http.Query(value = "branch_id")
    int branchId);
}