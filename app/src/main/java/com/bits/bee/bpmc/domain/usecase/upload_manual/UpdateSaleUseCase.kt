package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.SaleRepository
import javax.inject.Inject

class UpdateSaleUseCase @Inject constructor(
    private val saleRepository: SaleRepository
) {
    suspend operator fun invoke(sale: Sale){
        saleRepository.updateSale(sale)
    }
}