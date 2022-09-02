package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.SaleAddOnD
import com.bits.bee.bpmc.domain.repository.SaleAddOnDRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSaleAddonDByAddonUseCase @Inject constructor(
    private val saleAddOnDRepository: SaleAddOnDRepository
) {
    operator fun invoke(id: Int): Flow<Resource<List<SaleAddOnD>>>{
        return saleAddOnDRepository.getSaleAddonDbyAddon(id)
    }
}