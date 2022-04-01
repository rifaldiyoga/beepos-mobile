package com.bits.bee.bpmc.data.source.remote.apiservices

import com.bits.bee.bpmc.data.source.remote.response.BranchResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 * Created by aldi on 17/03/22.
 */
interface BranchApiService {

    @GET("/master/branch")
     fun getBranchList() : Flow<ApiResponse<BranchResponse>>

}