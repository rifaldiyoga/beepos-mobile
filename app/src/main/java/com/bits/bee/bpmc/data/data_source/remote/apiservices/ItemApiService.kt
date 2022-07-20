package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.*
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by aldi on 30/03/22.
 */
interface ItemApiService {

    @GET("v1/item/")
    fun getItem(@Path("id") id : Int = 317) : Flow<ApiResponse<ItemResponse>>

    @GET("v2/initialitem")
    fun getInitialItem(@Query("page") page : Int) : Flow<ApiResponse<ItemResponse>>

    @GET("v1/itemtaxsingle")
    fun getItemTax(): Flow<ApiResponse<ItemTaxResponse>>

    @GET("v1/itemkitchen")
    fun getItemKitchen(): Flow<ApiResponse<ItemKitchenResponse>>

    @GET("v1/itembranch")
    fun getItemBranch() : Flow<ApiResponse<ItemBranchResponse>>

}