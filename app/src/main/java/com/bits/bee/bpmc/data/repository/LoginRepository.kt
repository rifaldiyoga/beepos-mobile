package com.bits.bee.bpmc.data.repository

import androidx.lifecycle.LiveData
import com.bits.bee.bpmc.data.source.remote.ApiUtils
import com.bits.bee.bpmc.data.source.remote.post.LoginPost
import com.bits.bee.bpmc.data.source.remote.response.LoginResponse
import com.bits.bee.bpmc.domain.repository.LoginRepositoryI
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 02/03/22.
 */

class LoginRepository @Inject constructor(
    private val utils: ApiUtils
) : LoginRepositoryI {

    override fun login(email: String, password: String): Flow<Resource<LoginResponse>> {

        val loginPost = LoginPost(email, password)

        return object : NetworkBoundResource<LoginResponse>(){

            override fun createCall(): Flow<ApiResponse<LoginResponse>> {

                return utils.getAuthApiService().login(loginPost)
            }
        }.getAsFlow()
    }
}