package com.bits.bee.bpmc.domain.usecase

import com.bits.bee.bpmc.data.repository.LoginRepository
import javax.inject.Inject

/**
 * Created by aldi on 02/03/22.
 */
class LoginInteractor @Inject constructor(
    private val loginRepository: LoginRepository
) {

    fun login(username : String, password : String) = loginRepository.login(username, password)

}