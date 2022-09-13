package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.SalePromo
import com.bits.bee.bpmc.domain.repository.SalePromoRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSalePromoBySaleUseCase @Inject constructor(
    private val salePromoRepository: SalePromoRepository
) {
    operator fun invoke(id: Int): Flow<Resource<List<SalePromo>>>{
        return salePromoRepository.getSalePromoBySale(id)
    }
}