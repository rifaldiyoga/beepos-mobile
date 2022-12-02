package com.bits.bee.bpmc.domain.usecase.analisa_sesi

import com.bits.bee.bpmc.domain.repository.CadjRepository
import com.bits.bee.bpmc.domain.repository.SaleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import javax.inject.Inject

class GetTotalPaidTunaiUseCase @Inject constructor(
    private val saleRepository: SaleRepository,
    private val cadjRepository: CadjRepository
) {
   suspend operator fun invoke(id: Int, trxNo: String): BigDecimal{
       return saleRepository.getTotalPaidTunai(id).first().add(cadjRepository.sumCashIn(trxNo).first())
    }
}