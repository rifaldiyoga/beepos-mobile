package com.bits.bee.bpmc.data.source.remote.apiservices

import androidx.lifecycle.LiveData
import com.bits.bee.bpmc.data.source.remote.post.LoginPost
import com.bits.bee.bpmc.data.source.remote.response.LoginResponse
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

}