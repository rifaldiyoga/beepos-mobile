package com.bits.bee.bpmc.domain.repository

import androidx.lifecycle.LiveData
import com.bits.bee.bpmc.data.source.remote.response.LoginResponse
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 02/03/22.
 */
interface LoginRepositoryI {

    fun login(email : String, password : String) : Flow<Resource<LoginResponse>>

}