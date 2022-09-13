package com.bits.bee.bpmc.domain.usecase.pilih_db

import com.bits.bee.bpmc.domain.model.User
import com.bits.bee.bpmc.domain.repository.UserRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserBySecretSauce @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(username: String, userapi: String): Flow<Resource<List<User>>>{
        return userRepository.getUserBySecretSauce(username, userapi)
    }
}