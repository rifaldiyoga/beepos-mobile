package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.SelectionDResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 * Created by aldi on 26/04/22.
 */
interface SelectionDApiService {

    @GET("v1/selectaddond")
    fun getSelectionD() : Flow<ApiResponse<SelectionDResponse>>

}