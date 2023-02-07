package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.post.BpPost
import com.bits.bee.bpmc.data.data_source.remote.response.BpResponse
import com.bits.bee.bpmc.data.data_source.remote.response.BpReturn
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by aldi on 30/03/22.
 */
interface BpApiService {

//    @GET("bp/bp/view/1")
    @GET("v1/bp")
    fun getBpList() : Flow<ApiResponse<BpResponse>>

    @POST("/api/v1/bpclientnew")
    fun postBpClient(@Body bpPost: BpPost): Flow<ApiResponse<BpReturn>>

}