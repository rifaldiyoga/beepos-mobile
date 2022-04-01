package com.bits.bee.bpmc.data.source.remote.apiservices

import androidx.lifecycle.LiveData
import com.bits.bee.bpmc.data.source.remote.response.BranchResponse
import com.bits.bee.bpmc.data.source.remote.response.CashierResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by aldi on 17/03/22.
 */
interface CashierApiService {

    @GET("/master/cashier")
    fun getCashierList() : Flow<ApiResponse<CashierResponse>>

}