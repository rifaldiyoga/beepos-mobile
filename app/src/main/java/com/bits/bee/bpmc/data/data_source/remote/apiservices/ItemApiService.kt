package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.ItemGroupResponse
import com.bits.bee.bpmc.data.data_source.remote.response.ItemResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by aldi on 30/03/22.
 */
interface ItemApiService {

    @GET("v1/item/view/{id}")
    fun getItem(@Path("id") id : Int = 317) : Flow<ApiResponse<ItemResponse>>
    
}