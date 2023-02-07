package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.remote.response.DbResponse
import com.bits.bee.bpmc.data.data_source.remote.response.LoginResponse
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 02/03/22.
 */
interface LoginRepository {

    fun login(email : String, password : String) : Flow<Resource<LoginResponse>>

    fun postDb(usename : String, dbName : String) : Flow<Resource<DbResponse>>

}