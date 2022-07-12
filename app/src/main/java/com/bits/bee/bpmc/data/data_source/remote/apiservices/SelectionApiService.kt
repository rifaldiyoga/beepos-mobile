package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.SelectionResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 * Created by aldi on 26/04/22.
 */
interface SelectionApiService {

    @GET("v1/selectaddon")
    fun getSelection() : Flow<ApiResponse<SelectionResponse>>

}