package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.model.GopayPost
import com.bits.bee.bpmc.data.data_source.remote.model.GopayRefundPost
import com.bits.bee.bpmc.data.data_source.remote.response.GopayRefundResponse
import com.bits.bee.bpmc.data.data_source.remote.response.GopayResponse
import com.bits.bee.bpmc.data.data_source.remote.response.GopayStatusResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


/**
 * Created by aldi on 21/10/22
 */
interface GopayApiService {

    @GET("/api/v1/gopaystatus")
    fun getGopayStatus(@Query("id") transactionID: String): Flow<ApiResponse<GopayStatusResponse>>

    @GET("/api/v1/gopaycancel")
    fun getGopayCancel(@Query("id") transactionID: String): Flow<ApiResponse<GopayStatusResponse>>

    @POST("/api/v1/gopaycharge")
    fun postGoPay(@Body goPayPost: GopayPost): Flow<ApiResponse<GopayResponse>>

    @POST("/api/v1/gopayrefund")
    fun postGopayRefund(
        @Query("id") transactionID: String,
        @Body goPayRefundPost: GopayRefundPost
    ): Flow<ApiResponse<GopayRefundResponse>>

}