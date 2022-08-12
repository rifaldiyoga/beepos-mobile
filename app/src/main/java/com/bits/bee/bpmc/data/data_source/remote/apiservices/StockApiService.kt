package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.StockResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by aldi on 26/04/22.
 */
interface StockApiService {

    @GET("v2/stock")
    fun getStockByItem(@Query("itemcode") itemCode : String,@Query("whcode") whCode : String) : Flow<ApiResponse<StockResponse>>

}