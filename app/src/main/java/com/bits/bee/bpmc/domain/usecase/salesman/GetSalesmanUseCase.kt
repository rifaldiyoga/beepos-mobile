package com.bits.bee.bpmc.domain.usecase.salesman

import com.bits.bee.bpmc.domain.model.Srep
import com.bits.bee.bpmc.domain.repository.SrepRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 05/10/22
 */
class GetSalesmanUseCase @Inject constructor(
    private val srepRepository: SrepRepository
) {

    operator fun invoke() : Flow<List<Srep>> {
        return srepRepository.getSrepList()
    }

}