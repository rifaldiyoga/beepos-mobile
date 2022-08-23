package com.bits.bee.bpmc.domain.usecase.analisa_sesi

import com.bits.bee.bpmc.domain.repository.SaleRepository
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal
import javax.inject.Inject

class GetCountNotaVoidUseCase @Inject constructor(
    private val saleRepository: SaleRepository
) {
    operator fun invoke(id: Int): Flow<BigDecimal>{
        return saleRepository.getTotalNotaVoid(id)
    }
}