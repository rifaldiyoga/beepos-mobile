package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.PossesRepository
import javax.inject.Inject

class UpdatePossesUseCase @Inject constructor(
    private val possesRepository: PossesRepository
) {
    suspend operator fun invoke(posses: Posses){
        possesRepository.updatePosses(posses)
    }
}