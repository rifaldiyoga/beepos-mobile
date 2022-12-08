package com.bits.bee.bpmc.domain.usecase.login.operator

import com.bits.bee.bpmc.domain.model.User
import com.bits.bee.bpmc.domain.repository.UserRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserEmailUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(user: String): Flow<List<User>>{
       return userRepository.getUserPin(user)
    }
}