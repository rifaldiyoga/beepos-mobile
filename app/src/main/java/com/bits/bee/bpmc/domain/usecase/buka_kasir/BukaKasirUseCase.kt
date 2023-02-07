package com.bits.bee.bpmc.domain.usecase.buka_kasir

import com.bits.bee.bpmc.domain.mapper.CashDataMapper
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cash
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.repository.CashRepository
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.domain.repository.UserRepository
import com.bits.bee.bpmc.domain.usecase.common.AddCashAUseCase
import com.bits.bee.bpmc.domain.usecase.common.AddCstrUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveUserUseCase
import com.bits.bee.bpmc.utils.BPMConstants
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 10/06/22.
 */
class BukaKasirUseCase @Inject constructor(
    private val possesRepository: PossesRepository,
    private val cashRepository: CashRepository,
    private val addCashAUseCase: AddCashAUseCase,
    private val addCstrUseCase: AddCstrUseCase,
    private val getActiveUserUseCase: GetActiveUserUseCase
){

    suspend operator fun invoke(modal : BigDecimal, shift : Int, branch: Branch, cashier: Cashier) {

        val user = getActiveUserUseCase().first()

        possesRepository.addPosses(modal, shift, branch, cashier, user ?: throw Exception("No active default user!"))

        val mPosses  = possesRepository.getActivePosses().first()

        val cash = Cash(
            code = "",
            name = "",
            balance = modal
        )
        cashRepository.addCash(CashDataMapper.fromDomainToDb(cash))

        val mCash = cashRepository.getLastId().first()

        addCashAUseCase(
            refId = mPosses?.possesId?.toLong() ?: throw Exception("No active posses!"),
            refType = BPMConstants.BPM_DEFAULT_TYPE_POSSES,
            cashId = mCash?.id ?: throw Exception("No active cash!"),
            cashierId = cashier.id,
            userId = mPosses.userId ,
            amt = modal
        )

        addCstrUseCase(
            refType = BPMConstants.BPM_DEFAULT_TYPE_POSSES,
            refNo = mPosses.trxNo,
            amt = modal,
            cashier = cashier,
            branch = branch,
            shift = shift,
            isBuka = true
        )

    }

}