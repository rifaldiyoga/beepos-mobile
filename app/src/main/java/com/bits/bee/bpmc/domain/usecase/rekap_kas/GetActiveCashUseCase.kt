package com.bits.bee.bpmc.domain.usecase.rekap_kas

import com.bits.bee.bpmc.domain.model.Cash
import com.bits.bee.bpmc.domain.repository.CashRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetActiveCashUseCase @Inject constructor(
    private val cashRepository: CashRepository
) {
    operator fun invoke(idPosses: Long): Flow<Cash?>{
        return cashRepository.getActiveCash(idPosses)
    }
}