package com.bits.bee.bpmc.domain.usecase.login

import com.bits.bee.bpmc.data.repository.LoginRepository
import javax.inject.Inject

/**
 * Created by aldi on 02/03/22.
 */
class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    operator fun invoke(username : String, password : String) = loginRepository.login(username, password)

}
















