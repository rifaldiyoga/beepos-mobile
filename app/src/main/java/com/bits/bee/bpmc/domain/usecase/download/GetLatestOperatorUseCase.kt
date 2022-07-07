package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.User
import com.bits.bee.bpmc.domain.repository.UserRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 23/06/22.
 */
class GetLatestOperatorUseCase @Inject constructor(
    private val userRepository: UserRepository
){

    suspend operator fun invoke() : Flow<Resource<List<User>>> {
        return userRepository.getUser()
    }

}