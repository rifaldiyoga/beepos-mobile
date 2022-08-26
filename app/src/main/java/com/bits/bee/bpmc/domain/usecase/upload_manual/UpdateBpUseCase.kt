package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.mapper.BpDataMapper
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.repository.BpRepository
import javax.inject.Inject

class UpdateBpUseCase @Inject constructor(
    private val bpRepository: BpRepository
) {
    suspend operator fun invoke(bp: Bp){
        bpRepository.updateBp(BpDataMapper.fromDomainToDb(bp))
    }
}