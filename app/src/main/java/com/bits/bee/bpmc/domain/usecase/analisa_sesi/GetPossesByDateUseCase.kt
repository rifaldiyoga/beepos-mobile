package com.bits.bee.bpmc.domain.usecase.analisa_sesi

import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPossesByDateUseCase @Inject constructor(
    private val possesRepository: PossesRepository
) {
    operator fun invoke(startDate: Long, endDate: Long): Flow<Resource<List<Posses>>>{
        return possesRepository.getJmlPossesByDate(startDate, endDate)
    }
}