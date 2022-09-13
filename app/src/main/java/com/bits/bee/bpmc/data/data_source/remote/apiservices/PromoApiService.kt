package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.PromoMultiResponse
import com.bits.bee.bpmc.data.data_source.remote.response.PromoResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 * Created by aldi on 26/04/22.
 */
interface PromoApiService {

    @GET("v1/promo")
    fun getPromo() : Flow<ApiResponse<PromoResponse>>

    @GET("v1/promomulti")
    fun getPromoMulti() : Flow<ApiResponse<PromoMultiResponse>>


}