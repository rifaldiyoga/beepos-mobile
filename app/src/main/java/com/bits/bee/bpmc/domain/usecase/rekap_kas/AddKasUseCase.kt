package com.bits.bee.bpmc.domain.usecase.rekap_kas

import com.bits.bee.bpmc.domain.mapper.CashDataMapper
import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.domain.model.Cash
import com.bits.bee.bpmc.domain.repository.CadjRepository
import com.bits.bee.bpmc.domain.repository.CashRepository
import com.bits.bee.bpmc.domain.repository.PossesRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import javax.inject.Inject

class AddKasUseCase @Inject constructor(
    private val cashRepository: CashRepository,
    private val possesRepository: PossesRepository,
    private val cadjRepository: CadjRepository
) {

    private var mCadj: Cadj? = null
    private var status = ""

    suspend operator fun invoke(cash: Cash, balance: BigDecimal) {

        var cashInAmount: BigDecimal = cash.balance.add(balance)
        val cashOutAmount: BigDecimal = cash.balance.subtract(balance)

        cadjRepository.getLastInOutStatus(cash.id!!.toLong()).collectLatest {
            mCadj = it
        }

        status = mCadj!!.status
        if (status.equals("i", ignoreCase = true)) {
            cash.balance = cashInAmount
            cashRepository.updateCash(cash)
        } else if (status.equals("o", ignoreCase = true)) {
            cash.balance = cashOutAmount
            cashRepository.updateCash(cash)
        }
    }
}