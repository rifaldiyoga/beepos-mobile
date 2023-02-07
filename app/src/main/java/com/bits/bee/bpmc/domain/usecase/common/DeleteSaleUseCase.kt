package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.SaleRepository
import javax.inject.Inject

/**
 * Created by aldi on 11/08/22.
 */
class DeleteSaleUseCase @Inject constructor(
    private val saleRepository: SaleRepository
){

    suspend operator fun invoke(sale: Sale) {
        saleRepository.deleteSale(sale)
    }

}