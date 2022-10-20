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

class AddKasKeluarMasukUseCase @Inject constructor(
    private val cadjRepository: CadjRepository
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
            trxDate = DateFormatUtils.formatDateToLong(BPMConstants.DEFAULT_DATE_FORMAT, Date()),
            isUploaded = false,
        )

        cadjRepository.addCadj(CadjDataMapper.fromDomainToDb(newCadj))

        val cadj_ = cadjRepository.getCadjLastRow().first()

        val code = TrxNoGeneratorUtils.counterNoTrxCadj(cadj_.id?.toLong() ?: 1, activeBranch!!, activeCashier!!)

        cadjRepository.updateCode(code ?: "KodeTes", cadj_.id ?: 1)
    }
}