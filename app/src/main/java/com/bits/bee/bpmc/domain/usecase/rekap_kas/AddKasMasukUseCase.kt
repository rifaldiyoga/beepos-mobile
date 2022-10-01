package com.bits.bee.bpmc.domain.usecase.rekap_kas

import com.bits.bee.bpmc.domain.mapper.CadjDataMapper
import com.bits.bee.bpmc.domain.mapper.CashDataMapper
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.repository.CadjRepository
import com.bits.bee.bpmc.domain.repository.CashRepository
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.bits.bee.bpmc.utils.TrxNoGeneratorUtils
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

class AddKasMasukUseCase @Inject constructor(
    private val cadjRepository: CadjRepository,
    private val cashRepository: CashRepository,
    private val possesRepository: PossesRepository
) {
    suspend operator fun invoke(
        cash: Cash,
        cashierId: Int?,
        user: Int?,
        note: String,
        reftype: String,
        balance: BigDecimal,
        mPosses: Posses?,
        status: String,
        autogen: Boolean,
        activeBranch: Branch?,
        activeCashier: Cashier?,
    ) {
        val newCadj = Cadj(
            cashAId = cash.id!!,
            cashierId = cashierId!!,
            operatorId = user!!,
            status = status,
            note = note,
            refType = reftype,
            autoGen = autogen,
            amount = balance,
            refNo = mPosses!!.trxNo,
            kodeCadj = "",
            trxDate = DateFormatUtils.formatDateToLong(BPMConstants.NEW_DATE_FORMAT, Date()),
            isUploaded = false,
        )

        cadjRepository.addCadj(CadjDataMapper.fromDomainToDb(newCadj))

        val cadj_ = cadjRepository.getCadjLastRow().first()

        val code = TrxNoGeneratorUtils.counterNoTrxCadj(cadj_.id?.toLong() ?: 1, activeBranch!!, activeCashier!!)

        cadjRepository.updateCode(code ?: "KodeTes", cadj_.id ?: 1)

        var status = ""
        var cashInAmount: BigDecimal = cashRepository.getActiveCash(cash.id!!.toLong()).first()!!.balance.add(balance)
        val cashOutAmount: BigDecimal = cashRepository.getActiveCash(cash.id!!.toLong()).first()!!.balance.subtract(balance)

        status = cadjRepository.getLastInOutStatus(cash.id!!.toLong()).first().status
        if (status.equals("i", ignoreCase = true)) {
            cash.balance = cashInAmount
            cashRepository.addCash(CashDataMapper.fromDomainToDb(cash))
        } else if (status.equals("o", ignoreCase = true)) {
            cash.balance = cashOutAmount
            cashRepository.addCash(CashDataMapper.fromDomainToDb(cash))
        }

        var statusPosses = ""
        val cashPossesInAmount: BigDecimal = mPosses.total.add(balance)
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