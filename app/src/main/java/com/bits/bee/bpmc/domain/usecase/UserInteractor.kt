package com.bits.bee.bpmc.domain.usecase

import com.bits.bee.bpmc.data.repository.UserRepository
import com.bits.bee.bpmc.data.source.local.model.User
import com.bits.bee.bpmc.domain.repository.UserRepositoryI
import javax.inject.Inject

/**
 * Created by aldi on 29/03/22.
 */
class UserInteractor @Inject constructor(private val userRepository: UserRepository) : UserRepositoryI {

    override fun getActiveUser(): User? = userRepository.getActiveUser()

}