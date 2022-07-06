package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.RegencyResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface RegencyApiService {
    @GET("master/regency/list")
    fun getRegencyList(@Query("page") page: Int): Flow<ApiResponse<RegencyResponse>>
}