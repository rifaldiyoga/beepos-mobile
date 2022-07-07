package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.BranchResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 * Created by aldi on 17/03/22.
 */
interface BranchApiService {

//    @GET("master/branch")
    @GET("v1/branch")
     fun getBranchList() : Flow<ApiResponse<BranchResponse>>

}