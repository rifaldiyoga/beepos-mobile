package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.DistrictResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface DistrictApiService {
    @GET("master/district/list")
    fun getDistrictList(@Query("page") page: Int): Flow<ApiResponse<DistrictResponse>>
}