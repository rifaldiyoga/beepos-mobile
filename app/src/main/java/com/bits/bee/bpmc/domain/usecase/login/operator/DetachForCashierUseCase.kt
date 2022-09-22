package com.bits.bee.bpmc.domain.usecase.login.operator

import com.bits.bee.bpmc.data.data_source.remote.model.CashierPost
import com.bits.bee.bpmc.domain.repository.CashierRepository
import javax.inject.Inject

class DetachForCashierUseCase @Inject constructor(
    private val cashierRepository: CashierRepository
) {
    operator fun invoke(cashierPost: CashierPost) = cashierRepository.detachCashier(cashierPost)
}