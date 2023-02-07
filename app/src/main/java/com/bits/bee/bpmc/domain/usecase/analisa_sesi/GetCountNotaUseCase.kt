package com.bits.bee.bpmc.domain.usecase.analisa_sesi

import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.SaleRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal
import javax.inject.Inject

class GetCountNotaUseCase @Inject constructor(
    private val saleRepository: SaleRepository
) {
    operator fun invoke(id: Int): Flow<BigDecimal>{
        return saleRepository.getTotalNota(id)
    }
}