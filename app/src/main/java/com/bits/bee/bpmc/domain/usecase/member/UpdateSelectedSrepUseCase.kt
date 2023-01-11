package com.bits.bee.bpmc.domain.usecase.member

import com.bits.bee.bpmc.domain.model.Srep
import com.bits.bee.bpmc.domain.repository.SrepRepository
import javax.inject.Inject

class UpdateSelectedSrepUseCase @Inject constructor(
    private val srepRepository: SrepRepository
) {

    suspend operator fun invoke(bp : Srep) {
        srepRepository.resetSelectedSrep()
        srepRepository.updateSrep(bp)
    }

}