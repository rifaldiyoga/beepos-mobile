package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.model.CashierPost
import com.bits.bee.bpmc.data.data_source.remote.response.CashierResponse
import com.bits.bee.bpmc.data.data_source.remote.response.CashierStatusResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


/**
 * Created by aldi on 17/03/22.
 */
interface CashierApiService {

    @GET("v1/cashier")
    fun getCashierList(@Query("branch_id") branchId : Int) : Flow<ApiResponse<CashierResponse>>

    @POST("/api/v1/activatecashier")
    fun postActivateCashier(@Body cashierPost: CashierPost): Flow<ApiResponse<CashierStatusResponse>>

    @POST("/api/v1/detachcashier")
    fun postDetachCashier(@Body cashierPost: CashierPost): Flow<ApiResponse<CashierStatusResponse>>
}