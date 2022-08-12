package com.bits.bee.bpmc.domain.usecase.tutup_kasir

import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.CashARepository
import com.bits.bee.bpmc.domain.repository.PossesRepository
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 14/06/22.
 */

class TutupKasirUseCase @Inject constructor (
    private val possesRepository: PossesRepository,
    private val cashARepository: CashARepository
) {

    suspend operator fun invoke(posses: Posses) {
        val cashList = cashARepository.getCashAByCash(posses.possesId!!).first()
        var endBal = BigDecimal.ZERO
        cashList.onEach {
            endBal.add(it.amount)
        }
        posses.endBal = endBal
        posses.endTime = Date()
        possesRepository.updatePosses(posses)
    }

}