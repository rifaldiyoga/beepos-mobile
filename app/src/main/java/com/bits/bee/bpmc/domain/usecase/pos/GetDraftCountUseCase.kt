package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.domain.repository.SaleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 12/05/22.
 */
class GetDraftCountUseCase @Inject constructor(
    private val saleRepository: SaleRepository
) {

    operator fun invoke() : Flow<Int>  = saleRepository.getDraftCount()
}