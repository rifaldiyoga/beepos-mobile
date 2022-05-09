package com.bits.bee.bpmc.data.source.remote.apiservices

import com.bits.bee.bpmc.data.source.remote.response.BpResponse
import com.bits.bee.bpmc.data.source.remote.response.CashierResponse
import com.bits.bee.bpmc.data.source.remote.response.ChannelResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 * Created by aldi on 30/03/22.
 */
interface BpApiService {

    @GET("bp/bp/view/1")
    fun getBpList() : Flow<ApiResponse<BpResponse>>

}