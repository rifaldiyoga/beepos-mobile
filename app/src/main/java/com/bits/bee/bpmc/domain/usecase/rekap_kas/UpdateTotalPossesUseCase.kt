package com.bits.bee.bpmc.domain.usecase.rekap_kas

import com.bits.bee.bpmc.domain.model.Cash
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.CadjRepository
import com.bits.bee.bpmc.domain.repository.PossesRepository
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import javax.inject.Inject

class UpdateTotalPossesUseCase @Inject constructor(
    private val possesRepository: PossesRepository,
    private val cadjRepository: CadjRepository
) {
    suspend operator fun invoke(mPosses: Posses?, balance: BigDecimal, cash: Cash) {
        var statusPosses = ""
        val cashPossesInAmount: BigDecimal = mPosses!!.total.add(balance)
        val cashPossesOutAmount: BigDecimal = mPosses.total.subtract(balance)

        statusPosses = cadjRepository.getLastInOutStatus(cash.id!!.toLong()).first().status
        if (statusPosses.equals("i", ignoreCase = true)) {
            mPosses.total = cashPossesInAmount
            mPosses.totIn = (if (mPosses.totIn == null) balance else mPosses.totIn!!.add(balance))
            possesRepository.updatePosses(mPosses)
        } else if (statusPosses.equals("o", ignoreCase = true)) {
            mPosses.total = cashPossesOutAmount
            mPosses.totOut = (if (mPosses.totOut == null) balance else mPosses.totOut!!.add(balance))
            possesRepository.updatePosses(mPosses)
        }
    }
}