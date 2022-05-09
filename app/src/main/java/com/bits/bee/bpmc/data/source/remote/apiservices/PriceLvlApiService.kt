package com.bits.bee.bpmc.data.source.remote.apiservices

import com.bits.bee.bpmc.data.source.remote.response.PriceLvlResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 * Created by aldi on 26/04/22.
 */
interface PriceLvlApiService {

    @GET("master/pricelvl")
    fun getPriceLvl() : Flow<ApiResponse<PriceLvlResponse>>

}