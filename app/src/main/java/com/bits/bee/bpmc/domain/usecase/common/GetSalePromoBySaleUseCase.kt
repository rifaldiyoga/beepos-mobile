package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.SalePromo
import com.bits.bee.bpmc.domain.repository.SalePromoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSalePromoBySaleUseCase @Inject constructor(
    private val salePromoRepository: SalePromoRepository
) {
    operator fun invoke(id: Int): Flow<List<SalePromo>>{
        return salePromoRepository.getSalePromoBySale(id)
    }
}