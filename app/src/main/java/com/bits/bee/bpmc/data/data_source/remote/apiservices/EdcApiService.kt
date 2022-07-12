package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.EdcResponse
import com.bits.bee.bpmc.data.data_source.remote.response.TaxResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 * Created by aldi on 30/03/22.
 */
interface EdcApiService {

    @GET("v1/edc")
    fun getTaxList() : Flow<ApiResponse<EdcResponse>>
    
}