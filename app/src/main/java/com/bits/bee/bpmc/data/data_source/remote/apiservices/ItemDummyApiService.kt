package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.ItemDummyResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap

interface ItemDummyApiService {

    @Multipart
    @POST("v1/item")
    fun postItemDummy(
        @Part("Item[1][name]") name: RequestBody,
        @Part("Item[1][itemtype_code]") itemtype: RequestBody,
        @Part("Item[1][itemgroup1]") itemgroup: RequestBody,
        @Part("Item[1][price1]") price: RequestBody,
        @PartMap partMap : HashMap<String, RequestBody>,
        @Part body: MultipartBody.Part?
    ): Flow<ApiResponse<ItemDummyResponse>>

}