package com.bits.bee.bpmc.domain.usecase.login

import com.bits.bee.bpmc.data.data_source.remote.response.DbResponse
import com.bits.bee.bpmc.domain.repository.LoginRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 06/09/22
 */
class PostDbUseCase @Inject constructor(
    private val loginRepository: LoginRepository
){

    operator fun invoke(username : String, dbName : String) : Flow<Resource<DbResponse>> = loginRepository.postDb(username, dbName)

}