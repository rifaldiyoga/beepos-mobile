package com.bits.bee.bpmc.domain.usecase.rekap_sesi

import com.bits.bee.bpmc.domain.model.User
import com.bits.bee.bpmc.domain.repository.UserRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(operatorId: Int): Flow<Resource<User>>{
        return userRepository.getUserById(operatorId)
    }
}