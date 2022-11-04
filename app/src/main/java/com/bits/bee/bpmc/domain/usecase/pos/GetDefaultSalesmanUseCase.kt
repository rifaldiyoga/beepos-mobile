package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.domain.model.Srep
import com.bits.bee.bpmc.domain.repository.SrepRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 26/04/22.
 */
class GetDefaultSalesmanUseCase @Inject constructor(
    private val srepRepository: SrepRepository
) {

    operator fun invoke() : Flow<Srep?> {
        return srepRepository.getDefaultSrep()
    }

}