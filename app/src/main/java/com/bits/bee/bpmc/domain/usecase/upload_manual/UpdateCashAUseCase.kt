package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.CashA
import com.bits.bee.bpmc.domain.repository.CashARepository
import javax.inject.Inject

class UpdateCashAUseCase @Inject constructor(
    private val cashARepository: CashARepository
) {
    suspend operator fun invoke(cashA: CashA){
        cashARepository.updateCasha(cashA)
    }
}