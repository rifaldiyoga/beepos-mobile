package com.bits.bee.bpmc.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.bits.bee.bpmc.data.source.remote.ApiUtils
import com.bits.bee.bpmc.data.source.remote.post.LoginPost
import com.bits.bee.bpmc.data.source.remote.post.RegisterPost
import com.bits.bee.bpmc.data.source.remote.response.LoginResponse
import com.bits.bee.bpmc.data.source.remote.response.RegisterResponse
import com.bits.bee.bpmc.domain.repository.InfoKontakRepositoryI
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

class InfoKontakRepository @Inject constructor(
    private val api: ApiUtils
): InfoKontakRepositoryI {
//    lateinit var utm: RegisterPost.UTM
    override fun infoKontak(
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