package com.bits.bee.bpmc.domain.usecase.tutup_kasir

import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.BranchRepository
import com.bits.bee.bpmc.domain.repository.CashARepository
import com.bits.bee.bpmc.domain.repository.CashierRepository
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.domain.usecase.common.AddCstrUseCase
import com.bits.bee.bpmc.utils.BPMConstants
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 14/06/22.
 */

class TutupKasirUseCase @Inject constructor (
    private val possesRepository: PossesRepository,
    private val cashARepository: CashARepository,
    private val addCstrUseCase: AddCstrUseCase,
    private val cashierRepository: CashierRepository,
    private val branchRepository: BranchRepository,
) {

    suspend operator fun invoke(posses: Posses) {
        val cashList = cashARepository.getCashAByCash(posses.possesId!!).first()

        var endBal = BigDecimal.ZERO
        cashList.onEach {
            endBal = endBal.add(it.amount)
        }
        posses.endBal = endBal
        posses.endTime = Date()
        posses.isUploaded = false

        posses.totalDiffCash = posses.totalActualCash - endBal

        possesRepository.updatePosses(posses)

        val cashier = cashierRepository.getCashierById(posses.cashierId).first()

        addCstrUseCase(
            refType = BPMConstants.BPM_DEFAULT_TYPE_POSSES,
            refNo = posses.trxNo ,
            amt = posses.endBal ?: BigDecimal.ZERO,
            cashier = cashier ?: throw Exception("Cashier not found!"),
            branch = branchRepository.getBranchById(cashier.branchId.toInt()).first() ?: throw Exception("Branch not found") ,
            shift = posses.shift,
            isBuka = false
        )

    }

}