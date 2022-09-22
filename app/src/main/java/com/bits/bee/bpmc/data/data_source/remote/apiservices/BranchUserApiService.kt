package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.response.BranchUserResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface BranchUserApiService {
    @GET("v1/branchusr")
    fun getBranchUserList(): Flow<ApiResponse<BranchUserResponse>>
}