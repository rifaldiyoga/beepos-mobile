package com.bits.bee.bpmc.domain.usecase.analisa_sesi

import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetActivePossesListUseCase @Inject constructor(
    private val possesRepository: PossesRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<Posses>>>{
        return possesRepository.getActivePossesList()
    }
}