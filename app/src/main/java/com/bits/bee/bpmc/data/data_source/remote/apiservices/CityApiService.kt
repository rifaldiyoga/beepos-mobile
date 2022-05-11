package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.CityResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 * Created by aldi on 30/03/22.
 */
interface CityApiService {

    @GET("master/city")
    fun getCityList() : Flow<ApiResponse<CityResponse>>
    
}