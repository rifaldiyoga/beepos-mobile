package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.PossesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 08/06/22.
 */
class GetActivePossesUseCase @Inject constructor(
    private val possesRepository: PossesRepository
){

    suspend operator fun invoke() : Flow<Posses?> {
        return possesRepository.getActivePosses()
    }

}