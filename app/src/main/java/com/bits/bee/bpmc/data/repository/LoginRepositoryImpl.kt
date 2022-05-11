package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.post.LoginPost
import com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse
import com.bits.bee.bpmc.domain.repository.LoginRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 02/03/22.
 */

class LoginRepositoryImpl @Inject constructor(
    private val utils: ApiUtils
) : LoginRepository {

     override fun login(email: String, password: String): Flow<Resource<LoginResponse>> {

        val loginPost = LoginPost(email, password)

        return object : NetworkBoundResource<LoginResponse>(){

            override fun createCall(): Flow<ApiResponse<LoginResponse>> {

                return utils.getAuthApiService().login(loginPost)
            }
        }.getAsFlow()
    }
}