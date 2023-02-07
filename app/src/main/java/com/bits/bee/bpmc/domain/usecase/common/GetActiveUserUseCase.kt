package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.User
import com.bits.bee.bpmc.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 23/06/22.
 */
class GetActiveUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    operator fun invoke() : Flow<User?> {
        return userRepository.getActiveUser()
    }
}