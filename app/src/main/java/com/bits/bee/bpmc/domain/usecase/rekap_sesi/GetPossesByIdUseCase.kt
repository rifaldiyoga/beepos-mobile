package com.bits.bee.bpmc.domain.usecase.rekap_sesi

import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPossesByIdUseCase @Inject constructor(
    private val possesRepository: PossesRepository
) {
    operator fun invoke(possesId: Int): Flow<Resource<Posses>>{
        return possesRepository.getPossesById(possesId)
    }
}