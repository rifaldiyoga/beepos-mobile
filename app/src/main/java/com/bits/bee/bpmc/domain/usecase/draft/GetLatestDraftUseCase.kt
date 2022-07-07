package com.bits.bee.bpmc.domain.usecase.draft

import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.SaleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 24/06/22.
 */
class GetLatestDraftUseCase @Inject constructor(
    private val saleRepository: SaleRepository
){

    operator fun invoke() : Flow<List<Sale>> {
        return saleRepository.getLatestDraftList()
    }

}