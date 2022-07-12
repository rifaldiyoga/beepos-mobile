package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.ProvinceResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProvinceApiService {
    @GET("master/province/list")
    fun getProvinceList(@Query("page") page: Int): Flow<ApiResponse<ProvinceResponse>>
}