package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.PriceLvlResponse
import com.bits.bee.bpmc.data.data_source.remote.response.UsrGrpResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 * Created by aldi on 26/04/22.
 */
interface UsrGrpApiService {

    @GET("v1/usrgrp")
    fun getUsrGrp() : Flow<ApiResponse<UsrGrpResponse>>

}