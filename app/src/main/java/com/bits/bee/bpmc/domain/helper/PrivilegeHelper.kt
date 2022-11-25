package com.bits.bee.bpmc.domain.helper

import com.bits.bee.bpmc.domain.repository.GrpPrvRepository
import com.bits.bee.bpmc.domain.repository.UserRepository
import com.bits.bee.bpmc.domain.repository.UsrGrpRepository
import com.bits.bee.bpmc.domain.usecase.common.GetActiveUserUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by aldi on 01/11/22
 */
@Singleton
class PrivilegeHelper @Inject constructor(
    private val usrGrpRepository: UsrGrpRepository,
    private val grpPrvRepository: GrpPrvRepository,
    private val getActiveUserUseCase: GetActiveUserUseCase,
    private val userRepository: UserRepository
) {

    suspend fun hasAccess(objCode : String, acsType : String, usrId : Int? = null) : Boolean {
        val user = if(usrId == null) getActiveUserUseCase().first() else userRepository.getUserById(usrId).first()
        val usrGrp = usrGrpRepository.getByUsrId(user?.id ?: throw Exception("No user active!")).first()
        val grpPrvList = grpPrvRepository.getGrpPrvByGrpId(usrGrp!!.grpId).first()

        return grpPrvList.firstOrNull { it.objCode == objCode && it.acsType == acsType }?.isEnable ?: false
    }

}