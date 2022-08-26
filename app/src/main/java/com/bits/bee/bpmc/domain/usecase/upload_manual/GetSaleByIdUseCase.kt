package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.SaleRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSaleByIdUseCase @Inject constructor(
    private val saleRepository: SaleRepository
) {
    operator fun invoke(id: Int): Flow<Resource<Sale>>{
        return saleRepository.getSaleById(id)
    }
}