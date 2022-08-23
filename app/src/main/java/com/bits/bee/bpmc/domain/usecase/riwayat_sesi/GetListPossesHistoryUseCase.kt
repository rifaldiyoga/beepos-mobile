package com.bits.bee.bpmc.domain.usecase.riwayat_sesi

import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListPossesHistoryUseCase @Inject constructor(
    private val possesRepository: PossesRepository
) {
    operator fun invoke(): Flow<Resource<List<Posses>>> {
        return possesRepository.getListPossesHistory()
    }
}
