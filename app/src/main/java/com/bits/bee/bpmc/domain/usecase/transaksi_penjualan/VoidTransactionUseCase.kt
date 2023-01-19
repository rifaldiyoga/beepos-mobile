package com.bits.bee.bpmc.domain.usecase.transaksi_penjualan

import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.CashARepository
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.domain.repository.SaleRepository
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.utils.BPMConstants
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Created by aldi on 11/08/22.
 */
class VoidTransactionUseCase @Inject constructor(
    private val saleRepository: SaleRepository,
    private val getActivePossesUseCase: GetActivePossesUseCase,
    private val possesRepository: PossesRepository,
    private val cashARepository: CashARepository
) {

    suspend operator fun invoke(sale : Sale) {
        sale.isVoid = true
        saleRepository.updateSale(sale)

        val cashA = cashARepository.getCashAByRefId(sale.id!!, BPMConstants.SALE).first()

        cashA?.let {
            cashA.isVoid = true
            cashARepository.updateCasha(cashA)
        }

        val posses = getActivePossesUseCase().first()
        posses?.let {
            posses.total = posses.total - sale.total
            posses.totIn = posses.totIn!! - sale.total
            possesRepository.updatePosses(posses)
        } ?: throw Exception("No posses active!")

    }

}