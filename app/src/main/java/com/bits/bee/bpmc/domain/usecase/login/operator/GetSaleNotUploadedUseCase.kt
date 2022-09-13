package com.bits.bee.bpmc.domain.usecase.login.operator

import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.SaleRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSaleNotUploadedUseCase @Inject constructor(
    private val saleRepository: SaleRepository
) {
    operator fun invoke(): Flow<Resource<List<Sale>>>{
        return saleRepository.getSaleNotUploaded()
    }
}