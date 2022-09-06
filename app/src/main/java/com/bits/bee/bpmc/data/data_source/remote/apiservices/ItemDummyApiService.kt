package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.ItemDummyResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ItemDummyApiService {

    @Multipart
    @POST("api/v1/item")
    fun postItemDummy(
        @Part("Item[1][name]") name: Any,
        @Part("Item[1][itemtype_code]") itemtype: Any,
        @Part("Item[1][itemgroup1]") itemgroup: Any,
        @Part("Item[1][price1]") price: Any,
        @Part("Item[1][unit1]") unit: Any,
        @Part body: Part?
    ): Flow<ApiResponse<ItemDummyResponse>>

}