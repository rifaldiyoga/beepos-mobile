package com.bits.bee.bpmc.domain.usecase.pilih_kasir

import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.repository.CashierRepository
import javax.inject.Inject

/**
 * Created by aldi on 07/06/22.
 */
class UpdateActiveCashierUseCase @Inject constructor(
    private val cashierRepository: CashierRepository
) {

    suspend operator fun invoke(cashier: Cashier) {
        cashierRepository.updateActiveCashier(cashier)
    }
}