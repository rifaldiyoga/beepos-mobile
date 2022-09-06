package com.bits.bee.bpmc.data.data_source.remote.apiservices

import com.bits.bee.bpmc.data.data_source.remote.post.LoginPost
import com.bits.bee.bpmc.data.data_source.remote.post.SignUpPost
import com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse
import com.bits.bee.bpmc.data.data_source.remote.response.RegisterResponse
import com.bits.bee.bpmc.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by aldi on 02/03/22.
 */

interface AuthApiService {

    @POST("/v1/auth/loginmobile")
    fun login(@Body lognPost: LoginPost) : Flow<ApiResponse<LoginResponse>>

    @POST("/rest/trial/signup")
    fun signup(@Body signUpPost: SignUpPost): Flow<ApiResponse<RegisterResponse>>
}