package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.repository.SaleRepository
import javax.inject.Inject

class UpdateIDBpUseCase @Inject constructor(
    private val saleRepository: SaleRepository
) {
    suspend fun invoke(oldIdCust: Int, idCust: Int){
        saleRepository.updateNewIdCust(oldIdCust, idCust)
    }
}