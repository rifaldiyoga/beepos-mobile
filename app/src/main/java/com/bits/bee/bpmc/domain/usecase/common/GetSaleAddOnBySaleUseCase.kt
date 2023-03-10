package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.model.SaleAddOn
import com.bits.bee.bpmc.domain.repository.SaleAddOnRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSaleAddOnBySaleUseCase @Inject constructor(
    private val saleAddOnRepository: SaleAddOnRepository
) {
   operator fun invoke(id: Int): Flow<SaleAddOn?> {
       return saleAddOnRepository.getSaleAddonBySale(id)
   }
}