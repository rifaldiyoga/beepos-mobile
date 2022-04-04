package com.bits.bee.bpmc.data.source.remote.apiservices

import com.bits.bee.bpmc.data.source.remote.response.PmtdResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 * Created by aldi on 30/03/22.
 */
interface PmtdApiService {

    @GET("master/pmtd")
    fun getPmtdList() : Flow<ApiResponse<PmtdResponse>>
    
}