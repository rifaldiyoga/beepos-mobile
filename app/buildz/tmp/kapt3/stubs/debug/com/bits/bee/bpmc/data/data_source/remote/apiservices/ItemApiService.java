package com.bits.bee.bpmc.data.data_source.remote.apiservices;

import java.lang.System;

/**
 * Created by aldi on 30/03/22.
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'J\u001e\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0003\u0010\t\u001a\u00020\u0007H\'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u0003H\'J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u0003H\'J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\u0003H\'\u00a8\u0006\u0010"}, d2 = {"Lcom/bits/bee/bpmc/data/data_source/remote/apiservices/ItemApiService;", "", "getInitialItem", "Lkotlinx/coroutines/flow/Flow;", "Lcom/bits/bee/bpmc/utils/ApiResponse;", "Lcom/bits/bee/bpmc/data/data_source/remote/response/ItemResponse;", "page", "", "getItem", "id", "getItemBranch", "Lcom/bits/bee/bpmc/data/data_source/remote/response/ItemBranchResponse;", "getItemKitchen", "Lcom/bits/bee/bpmc/data/data_source/remote/response/ItemKitchenResponse;", "getItemTax", "Lcom/bits/bee/bpmc/data/data_source/remote/response/ItemTaxResponse;", "app_debug"})
public abstract interface ItemApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v1/item/")
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.ApiResponse<com.bits.bee.bpmc.data.data_source.remote.response.ItemResponse>> getItem(@retrofit2.http.Path(value = "id")
    int id);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v2/initialitem")
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.ApiResponse<com.bits.bee.bpmc.data.data_source.remote.response.ItemResponse>> getInitialItem(@retrofit2.http.Query(value = "page")
    int page);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v1/itemtaxsingle")
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.ApiResponse<com.bits.bee.bpmc.data.data_source.remote.response.ItemTaxResponse>> getItemTax();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v1/itemkitchen")
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.ApiResponse<com.bits.bee.bpmc.data.data_source.remote.response.ItemKitchenResponse>> getItemKitchen();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "v1/itembranch")
    public abstract kotlinx.coroutines.flow.Flow<com.bits.bee.bpmc.utils.ApiResponse<com.bits.bee.bpmc.data.data_source.remote.response.ItemBranchResponse>> getItemBranch();
    
    /**
     * Created by aldi on 30/03/22.
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public final class DefaultImpls {
    }
}