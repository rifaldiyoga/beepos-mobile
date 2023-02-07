package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.repository.BpRepository
import javax.inject.Inject

class UpdateSelectedBpUseCase @Inject constructor(
    private val bpRepository: BpRepository
) {

    suspend operator fun invoke(bp : Bp) {
        bpRepository.resetSelectedBp()
        bpRepository.updateBp(bp)
    }

}