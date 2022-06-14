package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.post.RegisterPost
import com.bits.bee.bpmc.data.data_source.remote.response.RegisterResponse
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InfoKontakRepository @Inject constructor(
    private val api: ApiUtils
) {
//    lateinit var utm: RegisterPost.UTM
     fun infoKontak(
        nama: String,
        noWA: String,
        email: String,
        pass1: String,
        pass2: String
    ): Flow<Resource<RegisterResponse>> {
        val infoKontakPost = RegisterPost(false,
            nama,
            email,
            "",
            "",
            "",
            "",
            "",
            noWA,
            "",
            1,
            0,
            "WA",
            RegisterPost.UTM()
        )

        return object : NetworkBoundResource<RegisterResponse>(){
            override fun createCall(): Flow<ApiResponse<RegisterResponse>> {
                return api.getAuthApiService().signup(infoKontakPost)
            }
        }.getAsFlow()
    }

}