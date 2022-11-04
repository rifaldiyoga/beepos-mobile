package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.mapper.BpDataMapper
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.repository.BpRepository
import javax.inject.Inject

/**
 * Created by aldi on 09/05/22.
 */
class AddUpdateMemberUseCase @Inject constructor(
    private val bpRepository: BpRepository
){

    suspend operator fun invoke(bp : Bp){
        bpRepository.addUpdateBp(bp)
    }

}