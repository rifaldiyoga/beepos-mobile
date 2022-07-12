package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.ItemAddOnResponse
import com.bits.bee.bpmc.data.data_source.remote.response.PriceLvlResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 * Created by aldi on 26/04/22.
 */
interface ItemAddOnApiService {

    @GET("v1/itemaddon")
    fun getPriceLvl() : Flow<ApiResponse<ItemAddOnResponse>>

}